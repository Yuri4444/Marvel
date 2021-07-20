package com.example.marvel.utils.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.utils.coroutines.ioToUi

import kotlinx.coroutines.Job

fun <T> ViewModel.ioToUi(
    io: suspend () -> T,
    ui: (T) -> Unit,
    exception: ((Exception) -> Unit)? = null
): Job = viewModelScope.ioToUi(io, ui, exception)