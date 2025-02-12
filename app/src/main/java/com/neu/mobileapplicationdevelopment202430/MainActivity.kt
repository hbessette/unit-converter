package com.neu.mobileapplicationdevelopment202430


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.neu.mobileapplicationdevelopment202430.databinding.ActivityMainBinding
import com.neu.mobileapplicationdevelopment202430.home.view.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(HomeFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()
    }

}