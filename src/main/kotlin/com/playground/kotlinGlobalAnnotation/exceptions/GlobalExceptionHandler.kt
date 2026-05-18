package com.playground.kotlinGlobalAnnotation.exceptions

import com.playground.kotlinGlobalAnnotation.dto.BaseResponse
import com.playground.kotlinGlobalAnnotation.enum.ResponseStatus
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(
        ex: MethodArgumentNotValidException
    ): ResponseEntity<BaseResponse<Any>> {

        val error = ex.bindingResult.allErrors.firstOrNull()
        val annotationCode = error?.code

        val status = when (annotationCode) {
            "ValidateString" -> ResponseStatus.BAD_REQUEST_USERNAME
            "ValidatePassword" -> ResponseStatus.BAD_REQUEST_PASSWORD
            else -> ResponseStatus.INTERNAL_ERROR
        }

        val response = BaseResponse<Any>(
            status = status,
            data = null,
        )

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response)
    }

    @ExceptionHandler(Exception::class)
    fun handleInternalException(
        ex: Exception
    ): ResponseEntity<BaseResponse<Any>> {

        val response = BaseResponse<Any>(
            status = ResponseStatus.INTERNAL_ERROR,
            data = null
        )

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response)
    }
}