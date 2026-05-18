package com.playground.kotlinGlobalAnnotation.enum

enum class ResponseStatus(
    val statusCode: String,
    val message: String,
    val description: String
) {
    SUCCESS("200","Success","Request successful"),
    BAD_REQUEST_USERNAME("400","Bad Request","Validation failed"),
    BAD_REQUEST_PASSWORD("400","Bad Request","Validation failed"),
    INTERNAL_ERROR("500","Internal Server Error","Unexpected error occurred")
}