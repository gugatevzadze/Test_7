package com.example.test_7.domain.repository

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun saveDarkMode(key: Preferences.Key<Boolean>, value: Boolean)

    suspend fun getDarkMode(key: Preferences.Key<Boolean>): Flow<Boolean>
}