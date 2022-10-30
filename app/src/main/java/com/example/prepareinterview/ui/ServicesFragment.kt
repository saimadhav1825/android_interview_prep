package com.example.prepareinterview.ui

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.prepareinterview.databinding.FragmentDashboardBinding
import com.example.prepareinterview.databinding.ServicesFragmentBinding
import com.example.prepareinterview.services.MyBoundService
import com.example.prepareinterview.services.SampleBackgroundService
import com.example.prepareinterview.services.SampleForeGroundService
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ServicesFragment : Fragment() {
    private var _binding: ServicesFragmentBinding? = null
    val TAG = "DashboardFragment"
    private lateinit var intent: Intent
    private lateinit var myBoundService: MyBoundService
    private var isBound = false

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = ServicesFragmentBinding.inflate(inflater, container, false)
        intent = Intent(requireContext(), SampleBackgroundService::class.java)
        val intent1 = Intent(requireContext(), SampleForeGroundService::class.java)
        //context?.startService(intent)
        // context?.startForegroundService(intent1)
        val root: View = binding.root
        binding.download.setOnClickListener {
            if (isBound) {
                lifecycleScope.launch {
                    myBoundService.getProgress().collectLatest {
                        binding.textDashboard.text = it.toString()
                    }
                }
            }
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }

    private val myBoundServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, binder: IBinder?) {
            val myBoundServiceBinder = binder as MyBoundService.MyServiceBinder
            myBoundService = myBoundServiceBinder.gerService()
            isBound = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            isBound = false
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(requireContext(), MyBoundService::class.java).also {
            context?.bindService(it, myBoundServiceConnection, Context.BIND_AUTO_CREATE)
        }
    }
}