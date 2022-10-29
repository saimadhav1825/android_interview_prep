package com.example.prepareinterview.retorfitwithhilt

data class EmployeeResponse(
    val data: List<Employee>?=null,
    val status: String?=""
)