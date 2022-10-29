package com.example.prepareinterview.retorfitwithhilt

import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SampleRepo @Inject constructor(
    private val api: SampleApiService,
    private val safeApiRequest: SafeApiRequest
) {

    suspend fun getEmployees(
    ) =
        flow {
            emit(DataState.Loading)
            emit(safeApiRequest.apiRequest { api.getEmployees() })
        }

}