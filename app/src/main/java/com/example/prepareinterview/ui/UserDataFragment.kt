package com.example.prepareinterview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.prepareinterview.adapters.MyAdapter.Companion.USERNAME_KEY
import com.example.prepareinterview.databinding.FragmentDashboardBinding
class UserDataFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    val TAG = "UserDataFragment"

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val name = arguments?.getString(USERNAME_KEY) ?: "Ali Connors"

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.textDashboard.text = name
        return root
    }
}