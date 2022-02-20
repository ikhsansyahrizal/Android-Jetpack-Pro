package com.dicoding.appfilm.data.source.remote

class ApiResponse<T>(val status: StatusResponse, val body: T, val message: String?) {

    companion object {

        fun <T> succes(body: T): ApiResponse <T> = ApiResponse(StatusResponse.SUCCES, body, null)

        fun <T> error(msg: String, body: T): ApiResponse<T> =
            ApiResponse(StatusResponse.ERROR, body, msg)
    }
}