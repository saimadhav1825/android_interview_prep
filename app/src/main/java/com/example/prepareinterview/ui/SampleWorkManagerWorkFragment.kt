package com.example.prepareinterview.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.work.*
import com.example.prepareinterview.databinding.SampleWorkmanagerFragmentBinding
import com.example.prepareinterview.workmanagerprepare.SampleWorkManager
import java.util.concurrent.TimeUnit

class SampleWorkManagerWorkFragment : Fragment() {
    //$ git clone https://github.com/googlecodelabs/android-workmanager
    var TAG = "SampleWorkManagerWorkFragment : "
    private var _binding: SampleWorkmanagerFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SampleWorkmanagerFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.workManger.setOnClickListener {
            oneTimePeriodicRequest()
        }
        return root
    }

    private fun oneTimePeriodicRequest() {
        val workManager = WorkManager.getInstance(requireContext())
        val uploadWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<SampleWorkManager>().setConstraints(workManagerConstraints())
                .setInputData(setDataForWorker())
                .build()
        workManager.enqueue(uploadWorkRequest)
        workManager.getWorkInfoByIdLiveData(uploadWorkRequest.id).observe(viewLifecycleOwner) {
            binding.workoutMangerText.text = it.state.name
            if (it.state.isFinished) {
                binding.workoutMangerText.text =
                    it.outputData.getInt(SampleWorkManager.KEY_COUNT, 0).toString()
            }
        }
    }

    //Constraints For Work Manager
    private fun workManagerConstraints(): Constraints {
        return Constraints.Builder().setRequiresCharging(false)
            .setRequiredNetworkType(NetworkType.CONNECTED).build()
    }

    //Set Data For WorkManager
    private fun setDataForWorker(): Data {
        return Data.Builder().putInt(SampleWorkManager.KEY_COUNT, 1000).build()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun periodicRequest() {
        val periodicWorkRequest =
            PeriodicWorkRequest.Builder(SampleWorkManager::class.java, 16, TimeUnit.MINUTES)
                .build()
        val workManager = WorkManager.getInstance(requireContext())
        workManager.enqueue(periodicWorkRequest)
    }
}