package com.example.prepareinterview.flowexamples

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.prepareinterview.databinding.ActivityMainBinding
import com.example.prepareinterview.databinding.FlowActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FlowExampleActivity : AppCompatActivity() {
    private val flowExampleViewModel: SampleFlowExampleViewModel by viewModels()
    var msg = "FlowExampleActivity : "
    private lateinit var binding: FlowActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FlowActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            /* flowExampleViewModel.sharedFlowCount.collectLatest {
                 binding.textview.text = it
             }*/
            flowExampleViewModel.flowExample().collectLatest {
                binding.textview.text = it.toString()
            }
        }
        binding.button.setOnClickListener {
            flowExampleViewModel.sharedFlowExample()
        }

    }
}