package com.example.beupdated.app

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.beupdated.authentication.presentation.AuthViewModel
import com.example.beupdated.authentication.presentation.authNavGraph
import com.example.beupdated.checkout.presentation.checkOutNavGraph
import com.example.beupdated.common.route.AppRoute
import com.example.beupdated.common.route.ProductDisplayRoute
import com.example.beupdated.notification.presentation.notificationNavGraph
import com.example.beupdated.order.presentation.orderNavGraph
import com.example.beupdated.orderdetails.presentation.orderDetailsNavGraph
import com.example.beupdated.paymentsuccess.presentation.paymentNavGraph
import com.example.beupdated.product.presentation.productNavGraph
import com.example.beupdated.productdisplay.presentation.ProductDisplayViewModel
import com.example.beupdated.productdisplay.presentation.productDisplayNavGraph
import com.example.beupdated.profile.presentation.profileNavGraph
import com.example.beupdated.registration.presentation.SignUpViewModel
import com.example.beupdated.registration.presentation.signUpNavGraph
import com.example.beupdated.savedproduct.presentation.savedProductNavGraph
import com.example.beupdated.search.presentation.searchNavGraph
import com.example.beupdated.ui.theme.BeUpdatedTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LOCKED
        enableEdgeToEdge()

        Thread.sleep(2500)
        installSplashScreen()

        setContent {
            BeUpdatedTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    val navController = rememberNavController()

                    NavGraph(
                        innerPadding = innerPadding,
                        navController = navController
                    )
                }
            }
        }

        this.actionBar?.hide()

    }
}

@Composable
fun NavGraph(
    innerPadding: PaddingValues,
    navController: NavHostController,
    authViewModel: AuthViewModel = hiltViewModel(),
    productDisplayViewModel: ProductDisplayViewModel = hiltViewModel(),
    signUpViewModel: SignUpViewModel = hiltViewModel()
) {
    authViewModel.retrieveUser()

    val user = authViewModel.state.user

    LaunchedEffect(Unit) {
        if (user != null) {
            navController.navigate(ProductDisplayRoute(user.email.toString())) {
                popUpTo(AppRoute.Auth.route) { inclusive = true }
            }
        }
    }

    NavHost(navController = navController, startDestination = AppRoute.Auth.route) {
        authNavGraph(
            navController = navController,
            viewModel = authViewModel
        )

        signUpNavGraph(
            navController = navController,
            viewModel = signUpViewModel
        )

        productDisplayNavGraph(
            navController = navController,
            viewModel = productDisplayViewModel,
            authViewModel = authViewModel,
            user = user
        )

        productNavGraph(
            navController = navController
        )

        checkOutNavGraph(
            navController = navController
        )

        notificationNavGraph(
            navController = navController
        )

        paymentNavGraph(
            navController = navController
        )

        savedProductNavGraph(
            navController = navController
        )

        searchNavGraph(
            navController = navController
        )

        profileNavGraph(
            navController = navController,
            authViewModel = authViewModel,
            productDisplayViewModel = productDisplayViewModel
        )

        orderNavGraph(
            navController = navController
        )

        orderDetailsNavGraph(
            navController = navController
        )
    }
}

