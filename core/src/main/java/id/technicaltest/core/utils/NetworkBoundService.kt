package id.technicaltest.core.utils

import id.technicaltest.core.source.remote.local.Resource
import id.technicaltest.core.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

fun <ResultType, RequestType> networkBoundResource(
    loadFromDatabase: () -> Flow<ResultType>,
    networkCall: suspend () -> Flow<ApiResponse<RequestType>>,
    saveCallResult: suspend (RequestType) -> Unit
): Flow<Resource<ResultType>> {
    return flow {
        emit(Resource.Loading())
        when (val responseStatus = networkCall().first()) {
            is ApiResponse.Success -> {
                responseStatus.data?.let { saveCallResult(it) }
                emitAll(loadFromDatabase().map {
                    Resource.Success(it)
                })
            }
            is ApiResponse.Error -> {
                emit(Resource.Error<ResultType>(responseStatus.msg))
                val dataSource = loadFromDatabase().first()
                if (dataSource != null) {
                    emitAll(loadFromDatabase().map {
                        Resource.Success(it)
                    })
                }
            }
        }
    }
}