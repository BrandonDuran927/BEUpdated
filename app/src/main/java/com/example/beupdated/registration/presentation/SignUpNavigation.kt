package com.example.beupdated.registration.presentation

import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.beupdated.common.route.AuthScreenRoute
import com.example.beupdated.common.route.SignUpScreenRouteA
import com.example.beupdated.common.route.SignUpScreenRouteB
import com.example.beupdated.common.route.SignUpScreenRouteC
import com.example.beupdated.common.route.SignUpScreenRouteD
import com.example.beupdated.registration.presentation.composables.AlertDialogEmailOTP
import com.example.beupdated.registration.presentation.composables.AlertDialogSMSOTP

fun NavGraphBuilder.signUpNavGraph(
    navController: NavController,
    viewModel: SignUpViewModel
) {
    composable<SignUpScreenRouteA> {
        LaunchedEffect(viewModel.state) {
            if (viewModel.state.onScreenB) {
                navController.navigate(SignUpScreenRouteB)
            }
        }

        SignUpScreenA(
            onReturnAuthScreen = {
                navController.navigate(AuthScreenRoute) {
                    popUpTo(SignUpScreenRouteA) {
                        inclusive = true
                    }
                }
            },
            state = viewModel.state,
            action = viewModel::onAction
        )
    }

    composable<SignUpScreenRouteB> {
        LaunchedEffect(viewModel.state) {
            if (!viewModel.state.onScreenB) {
                navController.navigate(SignUpScreenRouteA)
            }
        }

        LaunchedEffect(viewModel.state) {
            if (viewModel.state.onScreenC) {
                navController.navigate(SignUpScreenRouteC)
            }
        }

        SignUpScreenB(
            onReturnAuthScreen = {
                navController.navigate(AuthScreenRoute) {
                    popUpTo(SignUpScreenRouteB) {
                        inclusive = true
                    }
                }
            },
            state = viewModel.state,
            action = viewModel::onAction
        )
    }

    composable<SignUpScreenRouteC> {
        LaunchedEffect(viewModel.state) {
            if (!viewModel.state.onScreenC) {
                navController.navigate(SignUpScreenRouteB)
            }
        }

        LaunchedEffect(viewModel.state) {
            if (viewModel.state.onScreenD) {
                navController.navigate(SignUpScreenRouteD)
            }
        }

        SignUpScreenC(
            onReturnAuthScreen = {
                navController.navigate(AuthScreenRoute) {
                    popUpTo(SignUpScreenRouteC) {
                        inclusive = true
                    }
                }
            },
            state = viewModel.state,
            action = viewModel::onAction
        )
    }

    composable<SignUpScreenRouteD> {
//        val showSMSOTP = remember { mutableStateOf(false) }
//        val showEmailOTP = remember { mutableStateOf(false) }
        val context = LocalContext.current

        LaunchedEffect(viewModel.state) {
            if (!viewModel.state.onScreenD) {
                navController.navigate(SignUpScreenRouteC)
            }
        }

        LaunchedEffect(viewModel.state) {
            if (viewModel.state.onAuthScreen) {
                Toast.makeText(
                    context,
                    "Sign-up is successful!",
                    Toast.LENGTH_SHORT
                ).show()
                navController.navigate(AuthScreenRoute) {
                    popUpTo(SignUpScreenRouteD) {
                        inclusive = true
                    }
                }
            }
        }

        SignUpScreenD(
            onReturnAuthScreen = {
                navController.navigate(AuthScreenRoute) {
                    popUpTo(SignUpScreenRouteD) {
                        inclusive = true
                    }
                }
            },
            state = viewModel.state,
            action = viewModel::onAction
        )
    }
}
