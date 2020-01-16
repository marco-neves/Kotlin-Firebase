package com.illicitintelligence.myrealtimeapp.util

import android.util.Log

object Logger {

    @JvmStatic
    fun logIt(message: String) {
        Log.d(Constants.LOG_TAG, message)
    }

    @JvmStatic
    fun logError(message: String) {
        Log.e(Constants.ERROR_TAG, message)
    }
}