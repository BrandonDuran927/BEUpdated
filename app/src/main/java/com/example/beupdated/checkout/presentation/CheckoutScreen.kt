package com.example.beupdated.checkout.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beupdated.R
import com.example.beupdated.checkout.presentation.composables.CheckoutItem
import com.example.beupdated.checkout.presentation.composables.DatePickerFieldToModal
import com.example.beupdated.productdisplay.presentation.DisplayableNumber
import com.example.beupdated.productdisplay.presentation.toDisplayDouble

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    onPaymentSuccessfulScreen: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 5.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                title = {
                    Text(
                        text = "Order Details",
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBackPressed()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Arrow Back",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(120.dp),
                containerColor = colorResource(R.color.gold)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 30.dp,
                                vertical = 5.dp
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Total",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )

                        Text(
                            text = "P 897.00",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Button(
                        modifier = Modifier.width(320.dp),
                        onClick = {
                            onPaymentSuccessfulScreen()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.blue),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text("Submit")
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.Start
        ) {
            items(carts) { item ->
                CheckoutItem(
                    image = item.image,
                    productName = item.productName,
                    productSize = item.productSize,
                    totalPrice = item.totalPrice
                )

                HorizontalDivider(modifier = Modifier.fillMaxWidth())
            }

            item {
                var selectedOption by remember { mutableStateOf("Gcash") }
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                    text = "Payment Method",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Gcash Option
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.padding(start = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(R.drawable.gcashlogo),
                                contentDescription = "Gcash option"
                            )

                            Text(
                                text = "Gcash",
                                fontSize = 22.sp,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }

                        // Gcash RadioButton
                        RadioButton(
                            selected = selectedOption == "Gcash",
                            onClick = {
                                selectedOption = "Gcash"
                            },
                            modifier = Modifier.padding(end = 10.dp),
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Black
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    // Credit Card Option
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.padding(start = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(R.drawable.mastercardlogo),
                                contentDescription = "Credit Card"
                            )

                            Text(
                                text = "Credit Card",
                                fontSize = 22.sp,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }

                        // Credit Card RadioButton
                        RadioButton(
                            selected = selectedOption == "Credit Card",
                            onClick = {
                                selectedOption = "Credit Card"
                            },
                            modifier = Modifier.padding(end = 10.dp)
                        )
                    }
                }

                HorizontalDivider(modifier = Modifier.fillMaxWidth())
            }

            item {
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                    text = "Date of retrieval",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    DatePickerFieldToModal(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                    )
                }
            }
        }
    }
}


internal val carts = listOf(
    Items("Traditional F/M Uniform SHS", "M", 399.00.toDisplayDouble(), R.drawable.traditionalunif),
    Items("Bulldog Tote Bag", "L", 99.00.toDisplayDouble(), R.drawable.totebag),
    Items("Traditional F/M Uniform SHS", "M", 399.00.toDisplayDouble(), R.drawable.traditionalmaleshs),
)

internal data class Items(
    val productName: String,
    val productSize: String,
    val totalPrice: DisplayableNumber,
    @DrawableRes val image: Int
)

@Preview
@Composable
private fun CheckOutScreenPrev() {
    CheckoutScreen(
        onBackPressed = {

        },
        onPaymentSuccessfulScreen = {}
    )
}



