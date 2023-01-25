package com.irv205.xmlwithcompose.core.di

import com.irv205.xmlwithcompose.data.networkdatasource.NetworkDataSourceImp
import com.irv205.xmlwithcompose.domain.service.NetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun provideMarvelNetworkSource(networkDataSourceImp: NetworkDataSourceImp): NetworkDataSource
}