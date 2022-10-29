package com.example.prepareinterview.retorfitwithhilt


import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

enum class ErrorCodes(val code: Int) {
    SocketTimeOut(-1)
}

open class SafeApiRequest
@Inject constructor(
    private val networkHelper: NetworkHelper
) {
    suspend fun <T : Any> apiRequest(dataRequest: suspend () -> T): DataState<T> {
        return try {
            if (networkHelper.isNetworkConnected()) {
                val response = dataRequest.invoke()
                DataState.Success(response)
            } else
                DataState.NetworkError(
                    NoInternetException("Please_check_your_internet_connection"),
                    "please_check_your_internet_connection"
                )

        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> DataState.GenericError(
                    throwable.message,
                    null
                )
                is HttpException -> {
                    val code = throwable.code()
                    DataState.GenericError(
                        getErrorMessage(code, throwable.message!!),
                        ErrorResponse(false,"false")
                    )
                }
                is SocketTimeoutException -> DataState.NetworkError(
                    throwable,
                    getErrorMessage(ErrorCodes.SocketTimeOut.code, throwable.message!!)
                )
                is NoInternetException -> DataState.NetworkError(
                    throwable,
                    throwable.message!!
                )

                else -> {
                    DataState.GenericError(throwable.message, null)
                }
            }
        }
    }
}

private fun getErrorMessage(code: Int, message: String): String {
    return when (code) {
        ErrorCodes.SocketTimeOut.code -> "Timeout"
        400 -> message
        401 -> "Wrong password entered"
        403 -> "Maximum Otp Reached"
        404 -> message
        else -> "Something went wrong"
    }
}


