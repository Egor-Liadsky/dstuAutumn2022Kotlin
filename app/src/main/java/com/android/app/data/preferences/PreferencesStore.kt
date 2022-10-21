package com.android.app.data.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesStore(context: Context) {

    private var preferences: SharedPreferences =
        context!!.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)

}