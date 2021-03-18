package com.mobgen.task.app.session

import android.content.Context
import android.content.SharedPreferences

class Session {
    companion object{

        private fun getSharedPreferences(context: Context?): SharedPreferences?{
            return context?.getSharedPreferences(Preferences.PREFERENCES_KEY, Context.MODE_PRIVATE)
        }


        fun remove(context: Context?, key: String?) {
            val sharedPreferences = getSharedPreferences(context)
            val editor = sharedPreferences?.edit()
            editor?.remove(key)
            editor?.apply()
        }

        fun removeKey(context: Context?, keyId: String?) {
            val sharedPreferences = getSharedPreferences(context)
            val editor = sharedPreferences?.edit()
            editor?.remove(keyId)
            editor?.apply()
        }

        fun getString(context: Context?, keyId: String?, defaultValue: String): String {
            val sharedPreferences = getSharedPreferences(context)
            return sharedPreferences?.getString(keyId, defaultValue) ?: ""
        }

        fun setString(context: Context?, keyId: String?, value: String?) {
            val sharedPreferences = getSharedPreferences(context)
            val editor = sharedPreferences?.edit()
            editor?.putString(keyId, value)
            editor?.apply()
        }

        fun getBoolean(context: Context?, keyId: String?, defaultValue: Boolean): Boolean {
            val sharedPreferences = getSharedPreferences(context)
            return sharedPreferences?.getBoolean(keyId, defaultValue) ?: false
        }

        fun setBoolean(context: Context?, keyId: String?, value: Boolean) {
            val sharedPreferences = getSharedPreferences(context)
            val editor = sharedPreferences?.edit()
            editor?.putBoolean(keyId, value)
            editor?.apply()
        }

        fun getInt(context: Context?, keyId: String?, defaultValue: Int): Int {
            val sharedPreferences = getSharedPreferences(context)
            return sharedPreferences?.getInt(keyId, defaultValue) ?: 0
        }

        fun setInt(context: Context?, keyId: String?, value: Int) {
            val sharedPreferences = getSharedPreferences(context)
            val editor = sharedPreferences?.edit()
            editor?.putInt(keyId, value)
            editor?.apply()
        }
    }

}