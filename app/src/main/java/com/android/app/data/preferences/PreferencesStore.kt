package com.android.app.data.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesStore(context: Context) {

    private var preferences: SharedPreferences =
        context.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)

    fun saveTheme(theme: Boolean) {
        preferences.edit().putBoolean("theme", theme).apply()
    }

    fun setSavedTheme(): Boolean {
        return preferences.getBoolean("theme", false)
    }

}