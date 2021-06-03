package com.example.vmdirectory.data.remote

import com.example.vmdirectory.utils.Resource
import retrofit2.Response

abstract class BaseNetworkData {

    protected suspend fun <T> getResponseData(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) return Resource.success(responseBody)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error("Network call has failed for a following reason: $message")
    }

}