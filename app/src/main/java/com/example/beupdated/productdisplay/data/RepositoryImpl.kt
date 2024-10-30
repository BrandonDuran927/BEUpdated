package com.example.beupdated.productdisplay.data

import com.example.beupdated.authentication.domain.AuthRepository
import com.example.beupdated.common.utilities.CustomResult
import com.example.beupdated.productdisplay.domain.ProductDisplayRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val authRepository: AuthRepository
) : ProductDisplayRepository {
    override suspend fun signOutUser(): CustomResult<Unit> {
            return try {
                val result = authRepository.signOutUser()
                result
            } catch (e: Exception) {
                CustomResult.Failure(e)
            }
    }
}