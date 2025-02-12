package com.neu.mobileapplicationdevelopment202430.home.viewModel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.neu.mobileapplicationdevelopment202430.R

class HomeViewModel: IHomeViewModel {
    override fun loadFragment(fragment: Fragment, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()
    }
}