package com.playground.kotlinGlobalAnnotation.dto

import com.playground.kotlinGlobalAnnotation.enum.ResponseStatus

data class BaseResponse<T>(
    val status: ResponseStatus,
    val data: T? = null
)