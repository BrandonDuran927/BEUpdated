package com.example.beupdated.profile.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.beupdated.authentication.presentation.AuthViewModel
import com.example.beupdated.common.route.AuthScreenRoute
import com.example.beupdated.common.route.NotificationScreenRoute
import com.example.beupdated.common.route.OrderScreenRoute
import com.example.beupdated.common.route.ProductDisplayRoute
import com.example.beupdated.common.route.ProfileScreenRoute
import com.example.beupdated.common.route.SavedProductScreenRoute
import com.example.beupdated.common.route.SearchScreenRoute
import com.example.beupdated.productdisplay.presentation.ProductDisplayAction
import com.example.beupdated.productdisplay.presentation.ProductDisplayViewModel

fun NavGraphBuilder.profileNavGraph(
    navController: NavController,
    authViewModel: AuthViewModel,
    productDisplayViewModel: ProductDisplayViewModel
) {
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
            },
            onLogout = {
                authViewModel.resetUser()
                productDisplayViewModel.onAction(ProductDisplayAction.OnLogoutUser)
                navController.navigate(AuthScreenRoute) {
                    popUpTo(ProductDisplayRoute("")) {
                        inclusive = true
                    }
                }
            }
        )
    }
}