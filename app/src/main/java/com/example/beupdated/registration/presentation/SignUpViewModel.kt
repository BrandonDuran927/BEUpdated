package com.example.beupdated.registration.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.beupdated.registration.domain.usecases.ValidateEmailAddressUseCase
import com.example.beupdated.registration.domain.usecases.ValidateNameUseCase
import com.example.beupdated.registration.domain.usecases.ValidatePasswordUseCase
import com.example.beupdated.registration.domain.usecases.ValidatePhoneNumberUseCase
import com.example.beupdated.registration.domain.usecases.ValidateStudentIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val validateNameUseCase: ValidateNameUseCase,
    private val validateEmailAddressUseCase: ValidateEmailAddressUseCase,
    private val validateStudentIdUseCase: ValidateStudentIdUseCase,
    private val validatePhoneNumberUseCase: ValidatePhoneNumberUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase
) : ViewModel() {
    var state by mutableStateOf(SignUpState())
        private set

    fun onAction(action: SignUpAction) {
        when (action) {
            is SignUpAction.OnFirstNameChange -> state = state.copy(firstName = action.fName)
            is SignUpAction.OnLastNameChange -> state = state.copy(lastName = action.lName)
            is SignUpAction.OnMiddleNameChange -> state = state.copy(middleName = action.mName)
            is SignUpAction.OnEmailAddressChange -> state =
                state.copy(emailAddress = action.emailAddress)

            is SignUpAction.OnStudentIdChange -> state = state.copy(studentID = action.studentId)
            is SignUpAction.OnPhoneNumberChange -> state =
                state.copy(phoneNumber = action.phoneNumber)

            is SignUpAction.OnPasswordChange -> state = state.copy(password = action.password)
            is SignUpAction.OnEmailOtpChange -> state = state.copy(emailOtp = action.emailOtp)
            is SignUpAction.OnSmsOtpChange -> state = state.copy(smsOtp = action.smsOtp)

            SignUpAction.OnResetError -> state = state.copy(errorMessage = "")
            SignUpAction.OnScreenB -> {
                if (validateNameUseCase.invoke(state.firstName, state.lastName)) {
                    state = state.copy(onScreenB = true)
                } else {
                    state = state.copy(errorMessage = "First name and last name must not be empty!")
                }
            }

            SignUpAction.OnReturnScreenA -> state = state.copy(onScreenB = false)
            SignUpAction.OnScreenC -> {
                if (validateEmailAddressUseCase.invoke(state.emailAddress)
                    && validateStudentIdUseCase.invoke(state.studentID)) {
                    state = state.copy(onScreenC = true)
                } else {
                    state =
                        state.copy(errorMessage = "Please enter a valid email address and student ID to continue.")
                }
            }

            SignUpAction.OnReturnScreenB -> state = state.copy(onScreenC = false)
            SignUpAction.OnScreenD -> {
                state = if (validatePhoneNumberUseCase.invoke(state.phoneNumber)) {
                    state.copy(onScreenD = true)
                } else {
                    state.copy(errorMessage = "Please enter a valid phone number to continue.")
                }
            }

            SignUpAction.OnReturnScreenC -> state = state.copy(onScreenD = false)
            SignUpAction.OnScreenVerification -> {
                state = if (validatePasswordUseCase.invoke(state.password)) {
                    state.copy(onSmsOtp = true)
                } else {
                    state.copy(errorMessage = "Password must be at least 8 characters.")
                }
            }
            SignUpAction.OnShowSmsOtp -> state = state.copy(onSmsOtp = true)
            SignUpAction.OnShowEmailOtp -> state = state.copy(onEmailOtp = true)
            SignUpAction.OnResetSmsOtp -> state = state.copy(onEmailOtp = false, onSmsOtp = false)
            SignUpAction.OnResetEmailOtp -> state = state.copy(onEmailOtp = false)

            SignUpAction.SignUpSuccessful -> state = SignUpState().copy(onAuthScreen = true)
        }
    }
}