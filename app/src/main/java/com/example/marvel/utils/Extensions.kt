package com.example.marvel.utils

import android.view.View

fun View.gone(): View {
    visibility = View.GONE
    return this
}

fun View.visible(): View {
    visibility = View.VISIBLE
    return this
}

fun View.invisible(): View {
    visibility = View.INVISIBLE
    return this
}