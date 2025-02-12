package com.neu.mobileapplicationdevelopment202430.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neu.mobileapplicationdevelopment202430.mvvm.model.IMVVMModel
import com.neu.mobileapplicationdevelopment202430.mvvm.model.MVVMModel
import com.neu.mobileapplicationdevelopment202430.utils.Utils

class MVVMViewModel: ViewModel(), IMVVMViewModel {
    private val model : IMVVMModel = MVVMModel()
    private val _conversionResult = MutableLiveData<String>()
    val conversionResult: LiveData<String> get() = _conversionResult
    override fun convert(input: String?, from: String, to: String) {
        try {
            val result = Utils().convert(input.toString().toDouble(), from, to);
            _conversionResult.value = "Result: $result"
        } catch (e: Exception){
            _conversionResult.value = e.message
        }

    }
}