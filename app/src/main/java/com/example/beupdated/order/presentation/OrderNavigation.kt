package com.example.beupdated.order.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.beupdated.common.route.NotificationScreenRoute
import com.example.beupdated.common.route.OrderDetailsScreenRoute
import com.example.beupdated.common.route.OrderScreenRoute
import com.example.beupdated.common.route.ProductDisplayRoute
import com.example.beupdated.common.route.ProfileScreenRoute
import com.example.beupdated.common.route.SavedProductScreenRoute
import com.example.beupdated.common.route.SearchScreenRoute

fun NavGraphBuilder.orderNavGraph(navController: NavController) {
    composable<OrderScreenRoute> {
        OrderScreen(
            onSearchScreen = {
                navController.navigate(SearchScreenRoute) {
                    popUpTo(OrderScreenRoute)
                }
            },
            onSavedProductScreen = {
                navController.navigate(SavedProductScreenRoute) {
                    popUpTo(OrderScreenRoute)
                }
            },
            onNotificationScreen = {
                navController.navigate(NotificationScreenRoute) {
                    popUpTo(OrderScreenRoute)
                }
            },
            onProfileScreen = {
                navController.navigate(ProfileScreenRoute) {
                    popUpTo(OrderScreenRoute)
                }
            },
            onProductDisplayScreen = {
                navController.navigate(ProductDisplayRoute("")) {
                    popUpTo(OrderScreenRoute) {
                        inclusive = true
                    }
                }
            },
            onOrderDetailsScreen = {
                navController.navigate(OrderDetailsScreenRoute) {
                    popUpTo(OrderScreenRoute)
                }
            }
        )
    }
}