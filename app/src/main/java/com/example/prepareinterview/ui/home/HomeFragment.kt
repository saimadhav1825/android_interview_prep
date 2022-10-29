package com.example.prepareinterview.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.prepareinterview.R
import com.example.prepareinterview.adapters.MyAdapter
import com.example.prepareinterview.databinding.FragmentHomeBinding
import com.example.prepareinterview.retorfitwithhilt.AuthStateEvent
import com.example.prepareinterview.retorfitwithhilt.DataState
import com.example.prepareinterview.retorfitwithhilt.Employee
import com.example.prepareinterview.retorfitwithhilt.SampleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val sampleViewModel: SampleViewModel by viewModels()
    var msg = "HomeFragment : "
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        getAllEmployees()
        observerData()
        Log.d(msg, "The onCreateView() event")
        return root
    }

    private fun getAllEmployees() {

        sampleViewModel.setStateEvent(AuthStateEvent.LoginUser)
    }

    private fun observerData() {
        sampleViewModel.signInData.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Success -> {
                    it.data.body()?.data
                    val viewAdapter = MyAdapter(it.data.body()?.data!!)

                    binding.leaderboardList.run {
                        // use this setting to improve performance if you know that changes
                        // in content do not change the layout size of the RecyclerView
                        setHasFixedSize(true)

                        // specify an viewAdapter (see also next example)
                        adapter = viewAdapter

                    }
                }
                is DataState.Loading -> {
                    //
                }
                is DataState.GenericError -> {
                    //
                }
                is DataState.NetworkError -> {
                    //
                }
                else -> {//
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d(msg, "The onDestroyView() event")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(msg, "The onAttach() event")
    }

    /** Called when the activity is first created.  */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(msg, "The onCreate() event")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(msg, "The onViewCreated() event")
    }

    /** Called when the activity is about to become visible.  */
    override fun onStart() {
        super.onStart()
        Log.d(msg, "The onStart() event")
    }

    /** Called when the activity has become visible.  */
    override fun onResume() {
        super.onResume()
        Log.d(msg, "The onResume() event")
    }

    /** Called when another activity is taking focus.  */
    override fun onPause() {
        super.onPause()
        Log.d(msg, "The onPause() event")
    }

    /** Called when the activity is no longer visible.  */
    override fun onStop() {
        super.onStop()
        Log.d(msg, "The onStop() event")
    }

    /** Called just before the activity is destroyed.  */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(msg, "The onDestroy() event")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(msg, "The onDetach() event")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(msg, "The onViewStateRestored() event")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(msg, "The onSaveInstanceState() event")
    }
}
