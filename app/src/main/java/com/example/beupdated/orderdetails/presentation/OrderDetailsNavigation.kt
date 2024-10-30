package com.example.beupdated.orderdetails.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.beupdated.common.route.CheckoutScreenRoute
import com.example.beupdated.common.route.OrderDetailsScreenRoute
import com.example.beupdated.common.route.PaymentSuccessfulScreenRoute

fun NavGraphBuilder.orderDetailsNavGraph(navController: NavController) {
    composable<OrderDetailsScreenRoute> {
        OrderDetailsScreen(
            onBackPressed = {
                navController.popBackStack()
            },
            onPaymentSuccessfulScreen = {
                navController.navigate(CheckoutScreenRoute) {
                    popUpTo(OrderDetailsScreenRoute)
                }
            }
        )
    }
}