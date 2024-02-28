package com.example.prepareinterview.hiltexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prepareinterview.databinding.SampleActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HiltSampleActivity : AppCompatActivity() {
    var TAG = "SampleActivity : "
    private lateinit var binding: SampleActivityBinding
    @Inject
    lateinit var  filedInjectSample:FiledInjectSample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //lifecycle scope is attached to lifecycle of a an activity if activity is cleared ,the coroutine will cancel

        binding = SampleActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        filedInjectSample.sampleFiledInjection()

    }
}