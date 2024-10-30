package com.example.beupdated.productdisplay.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beupdated.authentication.domain.usecases.SignOutUseCase
import com.example.beupdated.common.utilities.CustomResult
import com.example.beupdated.productdisplay.domain.ProductDisplayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDisplayViewModel @Inject constructor(
    private val signOutUseCase: SignOutUseCase
) : ViewModel() {
    var state by mutableStateOf(ProductDisplayUIState())

    fun onAction(action: ProductDisplayAction) {
        when (action) {
            ProductDisplayAction.OnLogoutUser -> {
                viewModelScope.launch {
                    when (val result = signOutUseCase.invoke()) {
                        is CustomResult.Success -> {
                            Log.d("Logout", "Logout successfully!")
                            state = state.copy(userEmail = "")
                        }
                        is CustomResult.Failure -> {
                            state = state.copy(message = result.exception.message.toString())
                        }
                        CustomResult.Loading -> {
                            state = state.copy(isLoading = true)
                        }
                    }
                }
            }
        }
    }
}