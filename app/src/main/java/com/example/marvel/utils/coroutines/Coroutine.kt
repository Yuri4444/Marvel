package com.example.marvel.utils.coroutines

import android.util.Log
import kotlinx.coroutines.*

fun <T> CoroutineScope.ioToUi(
    io: suspend () -> T,
    ui: (T) -> Unit,
    exception: ((Exception) -> Unit)? = null
): Job {
    return launch(Dispatchers.IO) {
        try {
            val result = io()
            withContext(Dispatchers.Main) {
                ui(result)
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                exception?.invoke(e)
                Log.e("Exception", e.toString())
            }
        }
    }
}