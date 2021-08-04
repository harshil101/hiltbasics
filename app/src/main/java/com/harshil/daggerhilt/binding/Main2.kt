package com.harshil.daggerhilt.binding

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

class Main2 @Inject constructor(private val fname: String, private val lname: String) {
    fun getName() {
        Log.d("-----Main2", "Car name is $fname $lname")
    }
}

@Module
@InstallIn(SingletonComponent::class)
class AppModule() {
    @Provides
    @Singleton
    @Fname
    fun provideFName(): String = "Mercs"

    @Provides
    @Singleton
    @Lname
    fun provideLName(): String = "Benz"
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Fname

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Lname