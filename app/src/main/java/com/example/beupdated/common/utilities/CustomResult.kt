package com.example.beupdated.common.utilities

sealed class CustomResult<out T> {
    data class Success<out T>(val data: T) : CustomResult<T>()
    data class Failure(val exception: Throwable) : CustomResult<Nothing>()
    data object Loading : CustomResult<Nothing>()

    // Helpers
    fun isSuccess(): Boolean = this is Success
    fun isFailure(): Boolean = this is Failure
    fun isLoading(): Boolean = this is Loading

    fun getOrNull() : T? = (this as? Success)?.data
    fun exceptionOrNull(): Throwable? = (this as? Failure)?.exception
}