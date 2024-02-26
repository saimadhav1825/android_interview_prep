package com.example.prepareinterview.kotlinpractices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoroutineViewModel @Inject constructor() : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count = _count.asStateFlow()

    fun sampleCount() {
        val scopr = CoroutineScope(Dispatchers.Default + SupervisorJob())
        viewModelScope.launch {
            println("Which Thread it run ${Thread.currentThread().name}")
            _count.value++
        }
    }
}