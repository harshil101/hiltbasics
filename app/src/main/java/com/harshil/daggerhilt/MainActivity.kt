package com.harshil.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.harshil.daggerhilt.binding.Main
import com.harshil.daggerhilt.binding.Main2
import com.harshil.daggerhilt.di.Car
import com.harshil.daggerhilt.di.Engine
import com.harshil.daggerhilt.di.Wheel
import com.harshil.daggerhilt.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var car: Car
    @Inject
    lateinit var main: Main
    @Inject
    lateinit var main2: Main2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // old way to inject viewmodel
     /*   private val viewModel: MainViewModel by viewModels{
            MainViewModelFactory(this, Repository(),
                intent.extras)
        }
*/
        //new way to inject
        val mainViewModel: MainViewModel by viewModels()

        mainViewModel.userLiveData.observe(this, Observer{
            println("-------------------$it")
        })

        car.assembleCar()
        main.getGeneratedCar()
    }
}