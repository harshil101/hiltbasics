package com.harshil.daggerhilt.manual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harshil.daggerhilt.InitApp
import com.harshil.daggerhilt.R
import com.harshil.daggerhilt.manual.network.RetroFitProvider
import com.harshil.daggerhilt.manual.utility.ManualDIViewModel
import com.harshil.daggerhilt.manual.utility.UserLocalDataSource
import com.harshil.daggerhilt.manual.utility.UserRemoteDataSource
import com.harshil.daggerhilt.manual.utility.UserRepository

class ManualDIActivity : AppCompatActivity() {
    private lateinit var loginViewModel: ManualDIViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_diactivity)

        // First way to get userRepo
        val remoteDataSource = UserRemoteDataSource(RetroFitProvider.createRetrofitInstance())
        val localDataSource = UserLocalDataSource()

        val userRepository = UserRepository(localDataSource, remoteDataSource)


        loginViewModel = ManualDIViewModel(userRepository)

        // Second way to get userRepo
        val appContainer = (application as InitApp).appContainer
        loginViewModel = ManualDIViewModel(appContainer.userRepository)
    }
}