package com.example.prepareinterview.kotlinpractices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class CoroutineViewModel @Inject constructor() : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count = _count.asStateFlow()

    fun sampleCount() {
        /* val scopr = CoroutineScope(Dispatchers.Default + SupervisorJob())
         viewModelScope.launch {
             println("Which Thread it run ${Thread.currentThread().name}")
             _count.value++
         }*/
//        viewModelScope.launch {
//            println("Which Thread it viewModelScope run ${Thread.currentThread().name}")
//            val resulk = async {
//                println("Which Thread it async run ${Thread.currentThread().name}")
//                delay(1000L)
//                100
//            }
//            _count.value=resulk.await()
//        }
        val job = CoroutineScope(Dispatchers.Main + SupervisorJob()).launch {
            // run on main thread ->Dispatcher.main
            // run on background thread ->Dispatcher.Io
            // run on background thread ->Dispatcher.Default
            // run on  main thread ->Dispatcher.UnConfined
            println("Which Thread it run ${Thread.currentThread().name}")
            _count.value++
        }
        job.cancel()
        /*runBlocking {
            //run on main thread
            println("Which Thread it run ${Thread.currentThread().name}")
            _count.value++
        }*/
    }

    suspend fun doTaskA() {
        println("Task A started")
        delay(2000) // Simulate some asynchronous work for 2 seconds
        println("Task A finished")
    }

    suspend fun doTaskB() {
        println("Task B started")
        delay(3000) // Simulate some asynchronous work for 3 seconds
        println("Task B finished")
    }

    fun runBlockingExamaple() {
        runBlocking {
            val jobA = launch { doTaskA() }
            val jobB = launch { doTaskB() }

            println("Launched both coroutines, now waiting for them to complete…")

// Wait for both coroutines to complete using join()
            jobA.join()
            jobB.join()

            println("Both coroutines have completed")
        }

    }
}