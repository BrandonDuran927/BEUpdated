package com.example.beupdated.productdisplay.presentation

data class ProductDisplayUIState(
    val userEmail: String = "",

    val isLoading: Boolean = false,
    val message: String = ""
)
