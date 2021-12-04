package com.example.toyweverse

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.toyweverse.base.ViewState
import com.example.toyweverse.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

            }
        }
    }
}
