package com.micahnyabuto.thera.ui.screens.settings

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.micahnyabuto.thera.utils.ThemePreference
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application): AndroidViewModel(application) {
    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow()

    @SuppressLint("StaticFieldLeak")
    private val context = application.applicationContext

    init {
        viewModelScope.launch {
            ThemePreference.getThemePreference(context).collect {
                _isDarkMode.value = it
            }
        }
    }

    fun toggleTheme(isDark: Boolean) {
        viewModelScope.launch {
            ThemePreference.saveThemePreference(context, isDark)
            _isDarkMode.value = isDark
        }
    }

}