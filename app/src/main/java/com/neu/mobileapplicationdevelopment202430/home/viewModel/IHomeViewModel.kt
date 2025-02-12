package com.neu.mobileapplicationdevelopment202430.home.viewModel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface IHomeViewModel {
    fun loadFragment(fragment: Fragment, fragmentManager: FragmentManager) {}
}