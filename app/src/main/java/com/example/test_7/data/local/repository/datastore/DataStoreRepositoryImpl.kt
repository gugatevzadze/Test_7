package com.example.test_7.data.local.repository.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.test_7.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreRepository {
    override suspend fun saveDarkMode(key: Preferences.Key<Boolean>, value: Boolean) {
        dataStore.edit { settings ->
            settings[key] = value
        }
    }

    override suspend fun getDarkMode(key: Preferences.Key<Boolean>): Flow<Boolean> {
        return dataStore.data
            .map { preferences ->
                preferences[key] ?: false
            }
    }
}