package com.example.toyweverse.di

import com.example.toyweverse.api.WeverseApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideWeverseApi(): WeverseApi {
        return WeverseApi.create()
    }
}