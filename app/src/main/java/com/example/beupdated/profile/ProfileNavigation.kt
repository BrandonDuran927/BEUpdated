package com.example.beupdated.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.beupdated.common.route.NotificationScreenRoute
import com.example.beupdated.common.route.OrderScreenRoute
import com.example.beupdated.common.route.ProductDisplayRoute
import com.example.beupdated.common.route.ProfileScreenRoute
import com.example.beupdated.common.route.SavedProductScreenRoute
import com.example.beupdated.common.route.SearchScreenRoute
import com.example.beupdated.profile.presentation.ProfileScreen

fun NavGraphBuilder.profileNavGraph(navController: NavController) {
    composable<ProfileScreenRoute> {
        ProfileScreen(
            onNotificationScreen = {
                navController.navigate(NotificationScreenRoute) {
                    popUpTo(ProfileScreenRoute)
                }
            },
            onSavedProductScreen = {
                navController.navigate(SavedProductScreenRoute) {
                    popUpTo(ProfileScreenRoute)
                }
            },
            onSearchScreen = {
                navController.navigate(SearchScreenRoute) {
                    popUpTo(ProfileScreenRoute)
                }
            },
            onProductDisplayScreen = {
                navController.navigate(ProductDisplayRoute("")) {
                    popUpTo(ProfileScreenRoute) {
                        inclusive = true
                    }
                }
            },
            onOrderScreen = {
                navController.navigate(OrderScreenRoute) {
                    popUpTo(ProfileScreenRoute) {
                        inclusive = true
                    }
                }
            }
        )
    }
}