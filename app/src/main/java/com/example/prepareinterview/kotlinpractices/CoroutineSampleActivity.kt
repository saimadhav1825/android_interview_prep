package com.example.prepareinterview.kotlinpractices

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.prepareinterview.databinding.SampleActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

@AndroidEntryPoint
class SampleActivity : AppCompatActivity() {
    var TAG = "SampleActivity : "
    private lateinit var binding: SampleActivityBinding
    private val hiltViewModel: CoroutineViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //lifecycle scope is attached to lifecycle of a an activity if activity is cleared ,the coroutine will cancel

        binding = SampleActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Which Main Thread it run ${Thread.currentThread().name}")

        lifecycleScope.launch {
            println("Which Main Thread it run lifecycleScope ${Thread.currentThread().name}")
            hiltViewModel.count.collectLatest {
                binding.textview.text = it.toString()
            }
        }
        binding.button.setOnClickListener {
            hiltViewModel.sampleCount()
        }
    }


    //Basic Introduction About Coroutines
    private fun introductionAboutCoroutine() {
        //suspend function will call in coroutine or another suspend function
        GlobalScope.launch {
            //delay will pause only the current coroutine and not block teh whole thread
            delay(1000L)
            Log.d(TAG, "GlobalScope ${Thread.currentThread().name}")
            //If main thread is finished then all the coroutines will cancel
        }
    }

    private fun multipleApiCallInSingleCoroutine() {
        //Here what is happening ,both log will print at a time after the both api call,
        //first api call will influence the second api ,so after both api call,log will print,
        //in this case it will take 2 milliseconds ,to print both logs,why because each network call have 1 millisecond so after two second it will print two logs
        GlobalScope.launch {
            val doNetworkCallOne = doNetworkCallOne()
            val doNetworkCallTwo = doNetworkCallTwo()
            Log.d(TAG, doNetworkCallOne)
            Log.d(TAG, doNetworkCallTwo)
        }
    }

    private fun singleApiCallInSingleCoroutine() {
        //Here what is happening ,both log print at a time after the both api call,
        //first api call will not influence the second api,both api call will run parallel ,why because we are api in different coroutines,
        //logs will print in 1 millisecond
        GlobalScope.launch {
            val doNetworkCallOne = doNetworkCallOne()
            Log.d(TAG, doNetworkCallOne)

        }
        GlobalScope.launch {
            val doNetworkCallTwo = doNetworkCallTwo()
            Log.d(TAG, doNetworkCallTwo)
        }
    }

    private suspend fun doNetworkCallOne(): String {
        delay(3000L)
        return "First NetworkCall"
    }

    private suspend fun doNetworkCallTwo(): String {
        delay(3000L)
        return "Two NetworkCall"
    }

    private fun withContextExample() {
        GlobalScope.launch {
            Log.d(TAG, "GlobalScope ${Thread.currentThread().name}")
            val donWithContextNetworkCall = donWithContextNetworkCall()
            withContext(Dispatchers.Main) {
                binding.textview.text = donWithContextNetworkCall
            }
        }
    }

    private suspend fun donWithContextNetworkCall(): String {
        delay(1000L)
        return "Hi Sample"
    }

    private fun runBlocking() {
        //run blocking with stop ui thread
        // Before RunBlocking
        //Start RunBlocking
        //end RunBlocking
        //After RunBlocking
        //GlobalScope main threadmain
        Log.d(TAG, "Before RunBlocking")
        kotlinx.coroutines.runBlocking {

            launch {
                delay(1000L)
                Log.d(TAG, "First Coroutine")
            }
            launch {
                delay(1000L)
                Log.d(TAG, "Second Coroutine")
            }
            Log.d(TAG, "Start RunBlocking")
            delay(3000L)

            Log.d(TAG, "end RunBlocking")
        }

        Log.d(TAG, "After RunBlocking")
    }

    private fun aysncAwait() {
        Log.d(TAG, "Asysn Start")
        GlobalScope.launch {
            //single coroutine take 6 second to print the output
            /* val time = measureTimeMillis {
                 val doNetworkCallOne = doNetworkCallOne()
                 val doNetworkCallTwo = doNetworkCallTwo()
                 Log.d(TAG, doNetworkCallOne)
                 Log.d(TAG, doNetworkCallTwo)
             }
             Log.d(TAG, "time of network call $time ms")*/

            //async await will run in parallel and return deferred object
            val time = measureTimeMillis {
                val first = async {
                    doNetworkCallOne()
                }
                val second = async {
                    doNetworkCallTwo()
                }
                Log.d(TAG, first.await())
                Log.d(TAG, second.await())
            }
            Log.d(TAG, "time of network call $time ms")

        }
        Log.d(TAG, "Asysn End")
    }

}