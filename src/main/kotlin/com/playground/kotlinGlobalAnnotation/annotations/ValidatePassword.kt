package com.playground.kotlinGlobalAnnotation.annotations

import com.playground.kotlinGlobalAnnotation.validator.ValidatePasswordValidator
import jakarta.validation.Constraint
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [ValidatePasswordValidator::class])
annotation class ValidatePassword(
    val message: String = "",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Any>> = []
)