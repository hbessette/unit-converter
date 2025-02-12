package com.neu.mobileapplicationdevelopment202430.utils

class Utils : IUtils {
    override fun convert(value: Double?, from: String, to: String): Double {
        if (value == null) {
            throw Exception(String.format("Invalid input. Must be a number."))
        } else if (from == to) {
            return value;
        } else if (from == "Pound" && to == "Kilogram") {
            return value / 2.205;
        } else if (from == "Kilogram" && to == "Pound") {
            return value * 2.205
        } else if (from == "Litre" && to == "Gallon") {
            return value / 3.785
        } else if (from == "Gallon" && to == "Litre") {
            return value * 3.785
        } else if (from == "Yard" && to == "Meter") {
            return value / 1.094
        } else if (from == "Meter" && to == "Yard") {
            return value * 1.094
        } else {
            throw Exception(String.format("Cannot convert. Must be same type of unit.", from, to))
        }
    }
}