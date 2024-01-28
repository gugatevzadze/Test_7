package com.example.test_7.domain.usecase.datastore

import com.example.test_7.domain.repository.DataStoreRepository
import com.example.test_7.domain.user_preference.UserPreference
import javax.inject.Inject

class GetDarkModeUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    suspend operator fun invoke() = dataStoreRepository.getDarkMode(key = UserPreference.DARK_MODE)
}