package com.example.beupdated.registration.presentation

sealed interface SignUpAction {
    data class OnFirstNameChange(val fName: String) : SignUpAction
    data class OnLastNameChange(val lName: String) : SignUpAction
    data class OnMiddleNameChange(val mName: String) : SignUpAction
    data class OnEmailAddressChange(val emailAddress: String) : SignUpAction
    data class OnStudentIdChange(val studentId: String) : SignUpAction
    data class OnPhoneNumberChange(val phoneNumber: String) : SignUpAction
    data class OnPasswordChange(val password: String) : SignUpAction
    data class OnSmsOtpChange(val smsOtp: String) : SignUpAction
    data class OnEmailOtpChange(val emailOtp: String) : SignUpAction
    data object OnResetError : SignUpAction

    data object OnScreenB : SignUpAction
    data object OnReturnScreenA : SignUpAction
    data object OnScreenC : SignUpAction
    data object OnReturnScreenB : SignUpAction
    data object OnScreenD : SignUpAction
    data object OnReturnScreenC : SignUpAction
    data object OnScreenVerification: SignUpAction
    data object OnShowSmsOtp: SignUpAction
    data object OnShowEmailOtp: SignUpAction
    data object OnResetSmsOtp: SignUpAction
    data object OnResetEmailOtp: SignUpAction
    data object SignUpSuccessful: SignUpAction
}