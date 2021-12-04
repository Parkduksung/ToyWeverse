package com.example.toyweverse.di


import com.example.toyweverse.data.repo.WeverseRepository
import com.example.toyweverse.data.repo.WeverseRepositoryImpl
import com.example.toyweverse.data.source.WeverseRemoteDataSource
import com.example.toyweverse.data.source.WeverseRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindWeverseRepository(weverseRepositoryImpl: WeverseRepositoryImpl): WeverseRepository

    @Singleton
    @Binds
    abstract fun bindWeverseRemoteDataSource(weverseRemoteDataSourceImpl: WeverseRemoteDataSourceImpl): WeverseRemoteDataSource

}

