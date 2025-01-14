package com.example.beupdated.profile.presentation

sealed interface ProfileAction {
    data object OnLogoutUser : ProfileAction
}