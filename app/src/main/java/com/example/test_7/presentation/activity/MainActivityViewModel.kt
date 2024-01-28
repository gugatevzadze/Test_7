package com.example.test_7.presentation.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_7.domain.usecase.datastore.GetDarkModeUseCase
import com.example.test_7.domain.usecase.datastore.SaveDarkModeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getDarkModeUseCase: GetDarkModeUseCase,
    private val saveDarkModeUseCase: SaveDarkModeUseCase
) : ViewModel() {

    fun getDarkMode() {
        viewModelScope.launch {
            getDarkModeUseCase()
        }
    }

    fun saveDarkMode(value: Boolean) {
        viewModelScope.launch {
            saveDarkModeUseCase(value)
        }
    }
}