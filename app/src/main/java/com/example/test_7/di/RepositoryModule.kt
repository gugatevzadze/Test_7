package com.example.test_7.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.test_7.data.local.repository.datastore.DataStoreRepositoryImpl
import com.example.test_7.domain.repository.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideDataStoreRepository(dataStore: DataStore<Preferences>): DataStoreRepository {
        return DataStoreRepositoryImpl(
            dataStore = dataStore
        )
    }
}