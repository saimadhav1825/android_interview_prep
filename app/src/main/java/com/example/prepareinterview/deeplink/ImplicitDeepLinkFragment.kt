package com.example.prepareinterview.deeplink

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.prepareinterview.databinding.FragmentImplicitDeeplinkBinding

class ImplicitDeepLinkFragment : Fragment() {
    var msg = "ImplicitDeepLinkFragment : "
    private var _binding: FragmentImplicitDeeplinkBinding? = null
    private val binding get() = _binding!!
    private val args: ImplicitDeepLinkFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentImplicitDeeplinkBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.productName.text = args.productName
        Log.d(msg, "The onCreateView() event")
        return root
    }
}