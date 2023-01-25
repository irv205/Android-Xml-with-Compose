package com.irv205.xmlwithcompose.core.di

import com.irv205.xmlwithcompose.data.repository.RepositoryImp
import com.irv205.xmlwithcompose.domain.repository.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repositoryImp: RepositoryImp): RickAndMortyRepository
}