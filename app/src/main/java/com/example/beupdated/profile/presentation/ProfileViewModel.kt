package com.example.beupdated.profile.presentation

import androidx.lifecycle.ViewModel
import com.example.beupdated.authentication.domain.usecases.SignOutUseCase
import com.example.beupdated.common.utilities.CustomResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val signOutUseCase: SignOutUseCase) : ViewModel() {
}