package com.playground.kotlinGlobalAnnotation.dto.request

import com.playground.kotlinGlobalAnnotation.annotations.ValidatePassword
import com.playground.kotlinGlobalAnnotation.annotations.ValidateString

data class RegisterUserRequest(

    @field:ValidateString(message = "User must contain only letters and numbers")
    val user: String?,

    @field:ValidatePassword(message = "Password must contain numbers")
    val password: String?,

    val firstName: String?,
    val lastName: String?
)