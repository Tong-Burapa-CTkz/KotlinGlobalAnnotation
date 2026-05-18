package com.playground.kotlinGlobalAnnotation.dto.request

import com.playground.kotlinGlobalAnnotation.annotations.ValidatePassword
import com.playground.kotlinGlobalAnnotation.annotations.ValidateString
import jakarta.validation.constraints.NotBlank

data class RegisterUserRequest(

    @field:ValidateString(message = "User must contain only letters and numbers")
    val user: String?,

    @field:ValidatePassword(message = "Password must contain numbers")
    val password: String?,

    @NotBlank(message = "Name must not be blank")
    val firstName: String?,
    @NotBlank(message = "Last Name must not be blank")
    val lastName: String?
)