package com.example.beupdated.product.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.beupdated.common.route.CheckoutScreenRoute
import com.example.beupdated.common.route.ProductScreenRoute

fun NavGraphBuilder.productNavGraph(navController: NavController) {
    composable<ProductScreenRoute> {
        ProductScreen(
            onBackPressed = {
                navController.popBackStack()
            },
            onCheckoutScreen = {
                navController.navigate(CheckoutScreenRoute) {
                    popUpTo(ProductScreenRoute)
                }
            }
        )
    }
}