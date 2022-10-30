package com.example.prepareinterview.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.prepareinterview.R
import com.example.prepareinterview.databinding.FragmentDashboardBinding
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    val TAG = "DashboardFragment"

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        textView.setOnClickListener {
            findNavController().navigate(R.id.navigation_dashboard_to_navigation_service)
        }
        /* GlobalScope.launch {
             delay(3000L)
             val networ1=network1()
             val networ2=network2()
             Log.d(TAG,"Which Theard ${Thread.currentThread().name}")
             Log.d(TAG,"Which Theard ${networ1}")
             Log.d(TAG,"Which Theard ${networ2}")
         }
         GlobalScope.launch(Dispatchers.IO) {
             val network1=network1()
             Log.d(TAG,"Which Theard ${Thread.currentThread().name}")
             withContext(Dispatchers.Main){
                 Log.d(TAG,"Which Theard ${Thread.currentThread().name}")
                 textView.text = network1
             }
         }*/
        Log.d(TAG, "Before ")

        /* runBlocking {
             launch(Dispatchers.IO) {
                 delay(2000L)
                 Log.d(TAG,"launch 1 ")
             }

             launch(Dispatchers.IO){
                 delay(2000L)
                 Log.d(TAG,"launch 2 ")
             }

             delay(3000L)
             Log.d(TAG,"In between ${Thread.currentThread().name}")
         }*/
/*

        GlobalScope.launch {
            val time= measureTimeMillis {
                val one = async { network1() }
                val two = async { network2() }
                Log.d(TAG, one.await())
                Log.d(TAG, two.await())
            }
            Log.d(TAG,time.toString())

            launch {
                delay(2000L)
                val one = network1()
                Log.d(TAG, one)
            }

            launch {
                delay(4000L)
                val two =network2()
                Log.d(TAG, two)
            }
        }
*/

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    suspend fun network1(): String {
        delay(3000L)
        return "Network1"
    }

    suspend fun network2(): String {
        delay(6000L)
        return "Network2"
    }
}

