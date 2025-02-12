package com.neu.mobileapplicationdevelopment202430.mvp.presenter

import com.neu.mobileapplicationdevelopment202430.mvp.model.IMVPModel
import com.neu.mobileapplicationdevelopment202430.mvp.model.MVPModel
import com.neu.mobileapplicationdevelopment202430.mvp.view.IMVPFragment

class MVPPresenter(private val view : IMVPFragment): IMVPPresenter {
    private val model : IMVPModel = MVPModel()

    override fun convert(input: String?, from: String, to: String) {
        try {
            val output : Double = model.convert(input, from, to)
            view.setResult(String.format("The result is %f", output))
        } catch (e: Exception) {
            view.setResult(e.localizedMessage)
            view.toast(e.localizedMessage)
        }
    }
}