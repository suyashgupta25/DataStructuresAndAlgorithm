package com.practice.junk

data class PasswordValidationState(
    val hasMinLength: Boolean = false,
    var hasNumber: Boolean = false,
    val hasLowerCaseCharacter: Boolean = false,
    val hasUpperCaseCharacter: Boolean = false
) {
    val isValidPassword: Boolean
        get() = hasMinLength && hasNumber && hasLowerCaseCharacter && hasUpperCaseCharacter
//    = hasMinLength && hasNumber && hasLowerCaseCharacter && hasUpperCaseCharacter
}

fun main() {
    val pv = PasswordValidationState(
        hasMinLength = true,
        hasNumber = true,
        hasLowerCaseCharacter = true,
        hasUpperCaseCharacter = true
    )
    System.out.println(pv.isValidPassword)

    pv.hasNumber = false
    System.out.println(pv.isValidPassword)
}