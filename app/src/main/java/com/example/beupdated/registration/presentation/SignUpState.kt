package com.example.beupdated.registration.presentation

data class SignUpState(
    val firstName: String = "",
    val lastName: String = "",
    val middleName: String = "",
    val emailAddress: String = "",
    val studentID: String = "",
    val phoneNumber: String = "",
    val password: String = "",
    val smsOtp: String = "",
    val emailOtp: String = "",
    val errorMessage: String = "",

    val onScreenB: Boolean = false,
    val onScreenC: Boolean = false,
    val onScreenD: Boolean = false,
    val onSmsOtp: Boolean = false,
    val onEmailOtp: Boolean = false,
    val onAuthScreen: Boolean = false
)