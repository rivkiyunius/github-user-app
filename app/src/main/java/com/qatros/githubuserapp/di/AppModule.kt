package com.qatros.githubuserapp.di

import com.qatros.githubuserapp.repository.DataRepository
import com.qatros.githubuserapp.repository.DataRepositoryImpl
import com.qatros.githubuserapp.repository.localdatasources.LocalDataSource
import com.qatros.githubuserapp.repository.localdatasources.LocalDataSourcesImpl
import com.qatros.githubuserapp.repository.remotedatasources.RemoteDataSources
import com.qatros.githubuserapp.repository.remotedatasources.RemoteDataSourcesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author rivki
 * Created 28/03/22 at 22.35
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRepository(repositoryImpl: DataRepositoryImpl): DataRepository = repositoryImpl

    @Provides
    @Singleton
    fun provideRemoteDataSources(remoteDataSourcesImpl: RemoteDataSourcesImpl): RemoteDataSources = remoteDataSourcesImpl

    @Provides
    @Singleton
    fun provideLocalDataSources(localDataSourcesImpl: LocalDataSourcesImpl): LocalDataSource = localDataSourcesImpl
}