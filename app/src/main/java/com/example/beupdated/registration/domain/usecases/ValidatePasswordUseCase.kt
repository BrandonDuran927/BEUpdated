package com.example.beupdated.registration.domain.usecases

import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor() {
    operator fun invoke(password: String) : Boolean {
        return password.length >= 8
    }
}