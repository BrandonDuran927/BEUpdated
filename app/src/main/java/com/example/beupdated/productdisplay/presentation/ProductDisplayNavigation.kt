package com.example.beupdated.productdisplay.presentation

import androidx.compose.material3.Scaffold
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.beupdated.authentication.presentation.AuthViewModel
import com.example.beupdated.common.route.AuthScreenRoute
import com.example.beupdated.common.route.NotificationScreenRoute
import com.example.beupdated.common.route.OrderScreenRoute
import com.example.beupdated.common.route.ProductDisplayRoute
import com.example.beupdated.common.route.ProductScreenRoute
import com.example.beupdated.common.route.ProfileScreenRoute
import com.example.beupdated.common.route.SavedProductScreenRoute
import com.example.beupdated.common.route.SearchScreenRoute
import com.google.firebase.auth.FirebaseUser

fun NavGraphBuilder.productDisplayNavGraph(
    navController: NavController,
    viewModel: ProductDisplayViewModel,
    authViewModel: AuthViewModel,
    user: FirebaseUser?
) {
    composable<ProductDisplayRoute> {
        val email = it.toRoute<ProductDisplayRoute>().email

        ProductDisplayScreen(
            user = user,
            action = viewModel::onAction,
            onLoggedOut = {
                authViewModel.resetUser()
                navController.navigate(AuthScreenRoute) {
                    popUpTo(ProductDisplayRoute(email)) {
                        inclusive = true
                    }
                }
            },
            onProductScreen = {
                navController.navigate(ProductScreenRoute) {
                    popUpTo(ProductDisplayRoute(email))
                }
            },
            onNotificationScreen = {
                navController.navigate(NotificationScreenRoute) {
                    popUpTo(ProductDisplayRoute(email))
                }
            }, {
                navController.navigate(SavedProductScreenRoute) {
                    popUpTo(ProductDisplayRoute(email))
                }
            },
            onSearchScreen = {
                navController.navigate(SearchScreenRoute) {
                    popUpToRoute
                }
            },
            onProfileScreen = {
                navController.navigate(ProfileScreenRoute) {
                    popUpTo(ProductDisplayRoute(email))
                }
            },
            onOrderScreen = {
                navController.navigate(OrderScreenRoute) {
                    popUpTo(ProductDisplayRoute(email))
                }
            }
        )
    }
}