package com.neu.mobileapplicationdevelopment202430.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neu.mobileapplicationdevelopment202430.R
import com.neu.mobileapplicationdevelopment202430.databinding.HomeLayoutBinding
import com.neu.mobileapplicationdevelopment202430.home.viewModel.HomeViewModel
import com.neu.mobileapplicationdevelopment202430.home.viewModel.IHomeViewModel
import com.neu.mobileapplicationdevelopment202430.mvp.view.MVPFragment
import com.neu.mobileapplicationdevelopment202430.mvvm.view.MVVMFragment

class HomeFragment: Fragment(), IHomeFragment {
    private lateinit var binding: HomeLayoutBinding
    private val vm : IHomeViewModel = HomeViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeLayoutBinding.inflate(inflater, container, false)
        setButtonListeners()
        return binding.root
    }

    private fun setButtonListeners() {
        binding.btnMvp.setOnClickListener {
            vm.loadFragment(MVPFragment(), parentFragmentManager)
        }

        binding.btnMvvm.setOnClickListener {
            vm.loadFragment(MVVMFragment(), parentFragmentManager)
        }
    }


}