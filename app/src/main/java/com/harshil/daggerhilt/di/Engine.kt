package com.harshil.daggerhilt.di

import android.util.Log
import javax.inject.Inject

class Engine @Inject constructor() {
    fun getEngine() {
        Log.d("-------Engine class", "getEngine: Engine started")
    }
}