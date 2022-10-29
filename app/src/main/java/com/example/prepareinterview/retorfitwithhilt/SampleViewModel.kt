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

    val signInData: LiveData<DataState<Response<EmployeeResponse>>>
        get() = _signInData

    private val _signInData: MutableLiveData<DataState<Response<EmployeeResponse>>> =
        MutableLiveData()


    fun setStateEvent(authStateEvent: AuthStateEvent) {
        viewModelScope.launch {
            when (authStateEvent) {
                is AuthStateEvent.LoginUser -> {
                    authRepo.getEmployees()
                        .onEach { dataState ->
                            _signInData.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is AuthStateEvent.None -> {
                    //DO nothing
                }
            }
        }

    }
}

sealed class AuthStateEvent {
    object LoginUser : AuthStateEvent()

    object None : AuthStateEvent()
}