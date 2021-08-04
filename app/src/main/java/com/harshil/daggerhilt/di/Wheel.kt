package com.harshil.daggerhilt.di

import android.util.Log
import javax.inject.Inject

class Wheel @Inject constructor() {
    fun getWheels() {
        Log.d("------Wheel class", "getWheels: Wheels ready to role")
    }
}