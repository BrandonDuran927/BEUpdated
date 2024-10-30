package com.example.beupdated.paymentsuccess.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.beupdated.common.route.AppRoute
import com.example.beupdated.common.route.PaymentSuccessfulScreenRoute
import com.example.beupdated.common.route.ProductDisplayRoute
import com.example.beupdated.common.route.ProductScreenRoute

fun NavGraphBuilder.paymentNavGraph(
    navController: NavController
) {
    composable<PaymentSuccessfulScreenRoute> {
        PaymentSuccessScreen(
            onProductDisplayScreen = {
                navController.navigate(ProductDisplayRoute("")) {
                    popUpTo(PaymentSuccessfulScreenRoute) {
                        inclusive = true
                    }
                }
            }
        )
    }
}