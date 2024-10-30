package com.example.beupdated.search.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beupdated.R
import com.example.beupdated.search.presentation.composables.SearchItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    onProductDisplayScreen: () -> Unit
) {
    var search by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(145.dp),
                title = {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, end = 15.dp),
                        value = search,
                        onValueChange = {
                            search = it
                        },
                        placeholder = {
                            Text(
                                text = "Search..",
                                fontSize = 20.sp
                            )
                        },
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    onProductDisplayScreen()
                                }
                            ) {
                                Icon(
                                    Icons.Default.Search,
                                    null,
                                    modifier = Modifier.size(25.dp)
                                )
                            }
                        },
                        shape = RoundedCornerShape(20.dp)
                    )
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(searches) { item ->
                SearchItem(
                    description = item.description
                )
                HorizontalDivider(modifier = Modifier.fillMaxWidth())
            }
            item {
                Box(
                    modifier = Modifier.fillMaxWidth().padding(top = 15.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        modifier = Modifier
                            .width(150.dp),
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.gold),
                            contentColor = Color.Black
                        )
                    ) {
                        Text(
                            text = "Clear searches"
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Prev() {
    SearchScreen(onProductDisplayScreen = {})
}

internal val searches = listOf(
    SearchModel("Small uniform for girl"),
    SearchModel("Big tumbler"),
    SearchModel("Sports bag that has a strap"),
)

internal data class SearchModel(
    val description: String
)