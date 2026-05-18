package com.playground.kotlinGlobalAnnotation.validator

import com.playground.kotlinGlobalAnnotation.annotations.ValidateString
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class ValidatePasswordValidator: ConstraintValidator<ValidateString, String> {
    override fun isValid(
        value: String?,
        context: ConstraintValidatorContext?
    ): Boolean {
        if (value.isNullOrBlank()) {
            return false
        }

        return value.matches(
            Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$")
        )
    }
}