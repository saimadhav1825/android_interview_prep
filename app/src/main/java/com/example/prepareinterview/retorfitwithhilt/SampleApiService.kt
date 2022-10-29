package com.example.prepareinterview.retorfitwithhilt

import retrofit2.Response
import retrofit2.http.GET

interface SampleApiService {
    @GET("employees")
    suspend fun getEmployees(): Response<EmployeeResponse>
}