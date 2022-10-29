package com.example.prepareinterview.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _mutableLiveData = MutableLiveData<Int>().apply {
        value = 0
    }

    private val _stateFlow = MutableStateFlow(0)
    private val _mutableSharedFlow = MutableSharedFlow<Int>(0)
    val liveData: LiveData<Int> = _mutableLiveData
    val stateFlow = _stateFlow.asStateFlow()
    val sharedFlow = _mutableSharedFlow.asSharedFlow()

    fun getLiveData(int: Int) {
        viewModelScope.launch {
            _mutableLiveData.postValue(int)
        }
    }

    fun getStateFlow(int: Int) {
        _stateFlow.value = int
    }

    fun getNormalFlow(): Flow<Int> {
        return flow {
            repeat(5){
                emit(it)
                delay(1000L)
            }
        }

    }

    fun  getSharedFlow(int: Int){
        viewModelScope.launch {
            _mutableSharedFlow.emit(int)
        }
    }

    /*  homeViewModel.liveData.observe(viewLifecycleOwner) {
      textView.text = it.toString()
  }*/
    /*  lifecycleScope.launchWhenStarted {
          homeViewModel.stateFlow.collectLatest {
              textView.text = it.toString()
              Snackbar.make(binding.root,it.toString(),Snackbar.LENGTH_LONG).show()
          }
      }*/
    /* lifecycleScope.launchWhenStarted {
         homeViewModel.getNormalFlow().collectLatest {
             textView.text = it.toString()
         }
     }*/

    /* lifecycleScope.launchWhenStarted {
         homeViewModel.sharedFlow.collectLatest {
             textView.text = it.toString()
             Snackbar.make(binding.root,it.toString(),Snackbar.LENGTH_LONG).show()
         }
     }
     binding.liveData.setOnClickListener {
         count++
         homeViewModel.getSharedFlow(count)
     }
     lifecycleScope.launchWhenCreated {
         while (true) {
             delay(1000L)
             Log.d(msg, "launchWhenStarted")
         }
     }
*/
}