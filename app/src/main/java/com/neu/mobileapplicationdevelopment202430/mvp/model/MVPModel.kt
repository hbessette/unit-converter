package com.neu.mobileapplicationdevelopment202430.mvp.model

import com.neu.mobileapplicationdevelopment202430.utils.Utils

class MVPModel: IMVPModel {
    override fun convert(arg1: String?, arg1Unit: String, arg2Unit: String): Double {
        try {
            return Utils().convert(arg1.toString().toDouble(), arg1Unit, arg2Unit);
        } catch (e: Exception) {
            throw e
        }
    }
}