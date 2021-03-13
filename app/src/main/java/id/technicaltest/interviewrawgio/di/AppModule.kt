package id.technicaltest.interviewrawgio.di

import id.technicaltest.core.domain.usecase.GamesUseCase
import id.technicaltest.core.domain.usecase.IGamesUseCase
import id.technicaltest.interviewrawgio.ui.detail.DetailViewModel
import id.technicaltest.interviewrawgio.ui.home.HomeViewModel
import id.technicaltest.interviewrawgio.ui.search.SearchViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<IGamesUseCase> {
        GamesUseCase(get())
    }
}

val viewModelModule = module {
    factory {
        Dispatchers.IO
    }
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        SearchViewModel(get())
    }
    viewModel {
        DetailViewModel(get(), get())
    }
}