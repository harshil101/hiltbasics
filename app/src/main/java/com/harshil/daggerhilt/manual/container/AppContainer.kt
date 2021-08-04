package com.harshil.daggerhilt.manual.container

import com.harshil.daggerhilt.manual.network.RetroFitProvider
import com.harshil.daggerhilt.manual.utility.UserLocalDataSource
import com.harshil.daggerhilt.manual.utility.UserRemoteDataSource
import com.harshil.daggerhilt.manual.utility.UserRepository

class AppContainer {
private val remoteDataSource = UserRemoteDataSource(RetroFitProvider.createRetrofitInstance())
private val localDataSource = UserLocalDataSource()

// userRepository is not private; it'll be exposed
val userRepository = UserRepository(localDataSource, remoteDataSource)
}