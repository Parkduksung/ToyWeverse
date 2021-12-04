package com.example.toyweverse.viewmodel

import android.app.Application
import com.example.toyweverse.api.response.ShopInfo
import com.example.toyweverse.base.BaseViewModel
import com.example.toyweverse.base.ViewState
import com.example.toyweverse.data.repo.WeverseRepository
import com.example.toyweverse.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    app: Application,
    private val weverseRepository: WeverseRepository
) : BaseViewModel(app) {

    fun getShopInfo() {
        ioScope.launch {
            when(val result =weverseRepository.getShopInfo() ) {
                is Result.Success -> {
                    viewStateChanged(HomeViewState.GetShopInfo(result.data.shopInfos))
                }

                is Result.Error -> {
                    viewStateChanged(HomeViewState.Error(result.exception.message ?: "GetShopInfoError"))
                }
            }
        }
    }

    sealed class HomeViewState : ViewState {
        data class GetShopInfo(val infoList : List<ShopInfo>) : HomeViewState()
        data class Error(val message : String) : HomeViewState()
    }
}