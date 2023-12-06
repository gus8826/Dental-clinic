package com.leaftware.dental.clinic.sharedPreference

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager private constructor(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setSavedString(key: String, valor: String) {
        sharedPreferences.edit().putString(key, valor).apply()
    }

    fun getString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun deliteString(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    companion object {
        private const val PREFS_NAME = "DentalClinicPreferences"

        @Volatile
        private var instance: PreferencesManager? = null

        fun getInstance(context: Context): PreferencesManager {
            return instance ?: synchronized(this) {
                instance ?: PreferencesManager(context).also { instance = it }
            }
        }
    }
}
