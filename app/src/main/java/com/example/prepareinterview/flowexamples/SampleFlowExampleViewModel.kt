package com.example.prepareinterview.flowexamples

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleFlowExampleViewModel @Inject constructor(

) : ViewModel() {
    //State Flow
    private val _count = MutableStateFlow(0)
    val count = _count.asStateFlow()

    private val _sharedFlowCount = MutableSharedFlow<String>()
    val sharedFlowCount = _sharedFlowCount.asSharedFlow()


    fun stateFlowExample() {
        _count.value += 1
    }

    fun sharedFlowExample() {
        viewModelScope.launch {
            _sharedFlowCount.emit("SharedFlow")
        }
    }

    fun flowExample() = flow {
        repeat(10) {
            delay(1000L)
            emit(it)
        }
    }
}