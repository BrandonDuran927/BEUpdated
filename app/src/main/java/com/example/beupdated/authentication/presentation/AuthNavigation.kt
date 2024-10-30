package com.example.beupdated.authentication.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.beupdated.authentication.presentation.composables.ResetPassword
import com.example.beupdated.common.route.AppRoute
import com.example.beupdated.common.route.AuthScreenRoute
import com.example.beupdated.common.route.ProductDisplayRoute

fun NavGraphBuilder.authNavGraph(
    navController: NavController,
    viewModel: AuthViewModel
) {
    composable<AuthScreenRoute> {
        Scaffold { innerPadding ->
            val isReset = remember { mutableStateOf(false) }
            AuthScreen(
                state = viewModel.state,
                action = viewModel::onAction,
                onLoggedIn = {
                    navController.navigate(ProductDisplayRoute(it)) {
                        popUpTo(AuthScreenRoute) {
                            inclusive = true
                        }
                    }
                },
                innerPadding = innerPadding,
                onRegister = {
                    navController.navigate(AppRoute.SignUpA.route)
                },
                onResetPassword = {
                    isReset.value = true
                }
            )

            if (isReset.value) {
                ResetPassword(
                    state = viewModel.state,
                    isReset = isReset,
                    action = viewModel::onAction
                )
            }
        }
    }
}