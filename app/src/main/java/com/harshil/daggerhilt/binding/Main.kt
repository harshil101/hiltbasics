package com.harshil.daggerhilt.binding

import android.util.Log
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

class IGenerateCarImpl @Inject constructor(private val name: String): IGenerateCar {

    override fun generateCar() {
        Log.d("-----IGenerateCarImpl", "Assembled car is $name")
    }

}

class Main @Inject constructor(private val iGenerateCar: IGenerateCar){
    fun getGeneratedCar() {
        iGenerateCar.generateCar()
    }
}

/*@Module
@InstallIn(SingletonComponent::class)
abstract class CarModule {
    @Binds
    @Singleton
    abstract fun generateModule(
        iGenerateCarImpl: IGenerateCarImpl,
        gson: Gson
    ): IGenerateCar
}*/

@Module
@InstallIn(SingletonComponent::class)
class CarModule {

    @Provides
    @Singleton
    @Fname
    fun getStringName(): String = "Ferrari"

    @Provides
    @Singleton
    @LName
    fun getStringName2(): String = "another"

    @Provides
    @Singleton
    fun generateModule(
        name: String
    ): IGenerateCar = IGenerateCarImpl(name)

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LName

