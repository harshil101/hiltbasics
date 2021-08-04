package com.harshil.daggerhilt.di

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(private val engine: Engine,
                              private val wheel: Wheel) {

    fun assembleCar(
    ) {
        engine.getEngine()
        wheel.getWheels()
        Log.d("-----Car", "assembleCar: Car is assembled")
    }
}