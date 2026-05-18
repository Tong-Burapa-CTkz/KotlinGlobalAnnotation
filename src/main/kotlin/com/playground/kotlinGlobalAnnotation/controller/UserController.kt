package com.playground.kotlinGlobalAnnotation.controller

import com.playground.kotlinGlobalAnnotation.dto.BaseResponse
import com.playground.kotlinGlobalAnnotation.dto.request.RegisterUserRequest
import com.playground.kotlinGlobalAnnotation.enum.ResponseStatus
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {

    @PostMapping("/register")
    fun registerUser(
        @Valid @RequestBody request: RegisterUserRequest
    ): ResponseEntity<BaseResponse<Map<String, String?>>> {

        val response = BaseResponse(
            status = ResponseStatus.SUCCESS,
            data = mapOf(
                "user" to request.user,
                "firstName" to request.firstName,
                "lastName" to request.lastName
            )
        )

        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }
}