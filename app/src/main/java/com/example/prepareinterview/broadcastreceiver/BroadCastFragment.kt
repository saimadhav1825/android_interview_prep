package com.example.prepareinterview.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.prepareinterview.databinding.BroadCastReceiverFragmentBinding
class BroadCastFragment : Fragment() {
    private var _binding: BroadCastReceiverFragmentBinding? = null
    private lateinit var airplaneMoodReceiver: AirplaneMoodReceiver
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BroadCastReceiverFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //BroadcastReceiver
        airplaneMoodReceiver = AirplaneMoodReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            context?.registerReceiver(airplaneMoodReceiver, it)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStop() {
        super.onStop()
        context?.unregisterReceiver(airplaneMoodReceiver)
    }
}