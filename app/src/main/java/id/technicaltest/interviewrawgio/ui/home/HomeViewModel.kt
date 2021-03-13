package id.technicaltest.interviewrawgio.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.technicaltest.core.domain.usecase.IGamesUseCase

class HomeViewModel(iBlownUseCase: IGamesUseCase) : ViewModel() {
    val games = iBlownUseCase.getGames().asLiveData()
}