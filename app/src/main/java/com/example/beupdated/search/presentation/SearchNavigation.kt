package com.example.beupdated.search.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.beupdated.common.route.ProductDisplayRoute
import com.example.beupdated.common.route.SearchScreenRoute

fun NavGraphBuilder.searchNavGraph(navController: NavController) {
    composable<SearchScreenRoute> {
        SearchScreen(
            onProductDisplayScreen = {
                navController.navigate(ProductDisplayRoute("")){
                    popUpTo(SearchScreenRoute) {
                        inclusive = true
                    }
                }
            }
        )
    }
}