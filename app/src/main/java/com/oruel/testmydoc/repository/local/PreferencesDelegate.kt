package com.oruel.testmydoc.repository.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.oruel.testmydoc.repository.local.PreferencesDelegate.constNameFile.NAME_DEFAULT
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PreferencesDelegate<T : Any>
    (private val preferences: SharedPreferences,
     private val key: String,
     private val default: T)
    : ReadWriteProperty<Any, T> {


    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        with(preferences) {
            return when (default) {
                is Int -> getInt(key, default) as T
                is Boolean -> getBoolean(key, default) as T
                is Float -> getFloat(key, default) as T
                is Long -> getLong(key, default) as T
                is String -> getString(key, default) as T
                else -> {
                    try {
                        val gson = GsonBuilder().create()
                        val fromGetString = this.getString(key, "")
                        if (fromGetString != "") {
                            return gson.fromJson(fromGetString, default::class.java)
                        } else default
                    } catch (e: JsonSyntaxException) {
                        return default
                    }
                }
            }
        }
    }


    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        with(preferences.edit()) {
            when (value) {
                is Int -> putInt(key, value)
                is Long -> putLong(key, value)
                is Boolean -> putBoolean(key, value)
                is Float -> putFloat(key, value)
                is String -> putString(key, value)
                else -> {
                    val json = GsonBuilder().create().toJson(value)
                    putString(key, json)
                }
            }
            apply()
        }
    }

    object constNameFile {
        val NAME_DEFAULT = "NAME_DEFAULT"
    }

    companion object {

    }
}
fun createSharedPreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences(NAME_DEFAULT, Context.MODE_PRIVATE)
}
