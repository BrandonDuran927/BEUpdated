package com.example.beupdated.common.route

import kotlinx.serialization.Serializable

@Serializable
data class ProductDisplayRoute(val email: String) {
    companion object {
        const val ROUTE = "com.example.beupdated.common.route.ProductDisplayRoute/{email}"
    }
}

@Serializable
data object AuthScreenRoute {
    const val ROUTE = "com.example.beupdated.common.route.AuthScreenRoute"
}

@Serializable
data object SignUpScreenRouteA {
    const val ROUTE = "com.example.beupdated.common.route.SignUpScreenRouteA"
}

@Serializable
data object SignUpScreenRouteB {
    const val ROUTE = "com.example.beupdated.common.route.SignUpScreenRouteB"
}

@Serializable
data object SignUpScreenRouteC {
    const val ROUTE = "com.example.beupdated.common.route.SignUpScreenRouteC"
}

@Serializable
data object SignUpScreenRouteD {
    const val ROUTE = "com.example.beupdated.common.route.SignUpScreenRouteD"
}

@Serializable
data object ProductScreenRoute {
    const val ROUTE = "com.example.beupdated.common.route.Product"
}

@Serializable
data object CheckoutScreenRoute {
    const val ROUTE = "com.example.beupdated.common.route.CheckoutScreenRoute"
}

@Serializable
data object NotificationScreenRoute {
    const val ROUTE = "com.example.beupdated.common.route.NotificationScreenRoute"
}

@Serializable
data object PaymentSuccessfulScreenRoute {
    const val ROUTE = "com.example.beupdated.common.route.PaymentSuccessfulScreenRoute"
}

@Serializable
data object SavedProductScreenRoute {
    const val ROUTE = "com.example.beupdated.common.route.SavedProductScreenRoute"
}

@Serializable
data object SearchScreenRoute {
    const val ROUTE = "com.example.beupdated.common.route.SearchScreenRoute"
}

@Serializable
data object ProfileScreenRoute {
    const val ROUTE = "com.example.beupdated.common.route.ProfileScreenRoute"
}

@Serializable
data object OrderScreenRoute {
    const val ROUTE = "com.example.beupdated.common.route.OrderScreenRoute"
}

@Serializable
data object OrderDetailsScreenRoute {
    const val ROUTE = "com.example.beupdated.common.route.OrderDetailsScreenRoute"
}



sealed class AppRoute(val route: String) {
    data object Auth: AppRoute(AuthScreenRoute.ROUTE)
    data object ProductDisplay: AppRoute(ProductDisplayRoute.ROUTE)
    data object SignUpA: AppRoute(SignUpScreenRouteA.ROUTE)
    data object SignUpB: AppRoute(SignUpScreenRouteB.ROUTE)
    data object SignUpC: AppRoute(SignUpScreenRouteC.ROUTE)
    data object SignUpD: AppRoute(SignUpScreenRouteD.ROUTE)
}


