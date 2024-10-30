package com.example.beupdated.checkout.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.beupdated.common.route.CheckoutScreenRoute
import com.example.beupdated.common.route.PaymentSuccessfulScreenRoute

fun NavGraphBuilder.checkOutNavGraph(navController: NavController) {
    composable<CheckoutScreenRoute> {
        CheckoutScreen(
            onBackPressed = {
                navController.popBackStack()
            },
            onPaymentSuccessfulScreen = {
                navController.navigate(PaymentSuccessfulScreenRoute) {
                    popUpTo(CheckoutScreenRoute) {
                        inclusive = true
                    }
                }
            }
        )
    }
}