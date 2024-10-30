package com.example.beupdated.productdisplay.data

import com.example.beupdated.authentication.domain.AuthRepository
import com.example.beupdated.productdisplay.domain.ProductDisplayRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DI {
    @Singleton
    @Provides
    fun provideRepository(authRepository: AuthRepository): ProductDisplayRepository =
        RepositoryImpl(authRepository)
}