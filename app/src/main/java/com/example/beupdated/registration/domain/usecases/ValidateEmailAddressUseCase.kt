package com.example.beupdated.registration.domain.usecases

import javax.inject.Inject

class ValidateEmailAddressUseCase @Inject constructor() {
    operator fun invoke(email: String) : Boolean {
        val regex = Regex("^[\\w.-]+@[\\w.-]+")
        return regex.matches(email)
    }
}