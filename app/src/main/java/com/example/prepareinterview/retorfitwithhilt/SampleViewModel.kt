package com.example.prepareinterview.retorfitwithhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val authRepo: SampleRepo
) : ViewModel() {

    val signInData: LiveData<Int>
        get() = _signInData

    private val _signInData: MutableLiveData<Int> =
        MutableLiveData()

    fun increaseCount() {

    }

    override fun onCleared() {
        super.onCleared()
        println("SampleViewModel")
    }
}

sealed class AuthStateEvent {
    object LoginUser : AuthStateEvent()

    object None : AuthStateEvent()
}