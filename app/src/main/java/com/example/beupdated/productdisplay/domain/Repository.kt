package com.example.beupdated.productdisplay.domain

import com.example.beupdated.common.utilities.CustomResult
import kotlinx.coroutines.flow.Flow

interface ProductDisplayRepository {
    suspend fun signOutUser() : CustomResult<Unit>
}