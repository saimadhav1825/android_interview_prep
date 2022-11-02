package com.example.prepareinterview.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.prepareinterview.R
import com.example.prepareinterview.broadcastreceiver.AirplaneMoodReceiver
import com.example.prepareinterview.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {
    private var _binding: FragmentNotificationsBinding? = null
    //private lateinit var airplaneMoodReceiver: AirplaneMoodReceiver
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.sampleWorkManager.setOnClickListener {
            findNavController().navigate(R.id.navigation_notifications_sampleWorkManager)
        }
        //BroadcastReceiver
        /*airplaneMoodReceiver = AirplaneMoodReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            context?.registerReceiver(airplaneMoodReceiver, it)
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStop() {
        super.onStop()
        //context?.unregisterReceiver(airplaneMoodReceiver)
    }
}