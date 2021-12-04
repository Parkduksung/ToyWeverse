package com.example.toyweverse.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.toyweverse.R
import com.example.toyweverse.base.BaseActivity
import com.example.toyweverse.base.ViewState
import com.example.toyweverse.databinding.ActivityMainBinding
import com.example.toyweverse.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }


    private fun initViewModel() {
        homeViewModel.viewStateLiveData.observe(this) { viewState: ViewState? ->
            (viewState as? HomeViewModel.HomeViewState)?.let {
                onChangedHomeViewState(
                    viewState
                )
            }
        }
    }

    private fun onChangedHomeViewState(viewState: HomeViewModel.HomeViewState) {
        when (viewState) {
            is HomeViewModel.HomeViewState.GetShopInfo -> {
                Log.d("결과", viewState.infoList.size.toString())
            }

            is HomeViewModel.HomeViewState.Error -> {
                Log.d("결과", viewState.message)
            }
        }
    }
}
