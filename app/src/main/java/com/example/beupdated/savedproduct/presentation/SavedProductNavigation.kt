package com.example.beupdated.savedproduct.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.beupdated.common.route.CheckoutScreenRoute
import com.example.beupdated.common.route.NotificationScreenRoute
import com.example.beupdated.common.route.OrderScreenRoute
import com.example.beupdated.common.route.ProductDisplayRoute
import com.example.beupdated.common.route.ProfileScreenRoute
import com.example.beupdated.common.route.SavedProductScreenRoute
import com.example.beupdated.common.route.SearchScreenRoute

fun NavGraphBuilder.savedProductNavGraph(navController: NavController) {
    composable<SavedProductScreenRoute> {
        SavedProductScreen(
            onCheckoutScreen = {
              navController.navigate(CheckoutScreenRoute) {
                  popUpTo(SavedProductScreenRoute)
              }
            },
            onProductDisplayScreen = {
                navController.navigate(ProductDisplayRoute("")) {
                    popUpTo(SavedProductScreenRoute) {
                        inclusive =  true
                    }
                }
            },
            onNotificationScreen = {
                navController.navigate(NotificationScreenRoute) {
                    popUpTo(SavedProductScreenRoute)
                }
            },
            onSearchScreen = {
                navController.navigate(SearchScreenRoute) {
                    popUpToRoute
                }
            },
            onProfileScreen = {
                navController.navigate(ProfileScreenRoute) {
                    popUpTo(SavedProductScreenRoute) {
                        inclusive = true
                    }
                }
            },
            onOrderScreen = {
                navController.navigate(OrderScreenRoute) {
                    popUpTo(SavedProductScreenRoute) {
                        inclusive = true
                    }
                }
            }
        )
    }
}