package com.example.beupdated.orderdetails.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beupdated.R
import com.example.beupdated.orderdetails.presentation.composables.OrderDetailsItem
import com.example.beupdated.productdisplay.presentation.DisplayableNumber
import com.example.beupdated.productdisplay.presentation.toDisplayDouble

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetailsScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    onPaymentSuccessfulScreen: () -> Unit

) {
    val local = LocalContext.current

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
                containerColor = Color.Transparent
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.width(320.dp),
                        onClick = {
                            onPaymentSuccessfulScreen()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.gold),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(
                            text = "Buy Again",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.blue)
                        )
                    }
                }
            }
        }
    )  { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White),
            horizontalAlignment = Alignment.Start
        ) {
            item {
                Spacer(Modifier.height(20.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    text = "Your Order is Completed",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.drawable.truckicon),
                        contentDescription = null
                    )
                    Text(
                        text = "Your item is already received",
                        fontSize = 20.sp
                    )
                }
                Spacer(Modifier.height(15.dp))
                HorizontalDivider(Modifier.fillMaxWidth())
            }

            items(totalItems) { item ->
                OrderDetailsItem(
                    image = item.image,
                    productName = item.productName,
                    productSize = item.productSize,
                    qty = item.qty,
                    price = item.price,
                    totalPrice = item.totalPrice
                )
            }

            item {
                HorizontalDivider(Modifier.fillMaxWidth())
                Spacer(Modifier.height(15.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    text = "Details",
                    fontSize = 20.sp
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    text = "Order Placed",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.drawable.dateicon),
                        contentDescription = null
                    )

                    Text(
                        text = "October 30, 2024",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light,

                        )

                    Spacer(Modifier.width(15.dp))

                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.drawable.timeicon),
                        contentDescription = null
                    )

                    Text(
                        text = "12:24:30",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light,

                        )

                }

                Spacer(Modifier.height(20.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    text = "Order Picked-Up",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.drawable.dateicon),
                        contentDescription = null
                    )

                    Text(
                        text = "November 04, 2024",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light,

                        )

                    Spacer(Modifier.width(15.dp))

                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(R.drawable.timeicon),
                        contentDescription = null
                    )

                    Text(
                        text = "13:21:20",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light,

                        )
                }
            }

            item {
                Spacer(Modifier.height(20.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    text = "Order ID",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    text = "25024DFJ21029KA029",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                )
            }

            item {
                Spacer(Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),

                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "E-Invoice",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    OutlinedButton(
                        onClick = {}
                    ) {
                        Text(
                            text = "Download",
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    OrderDetailsScreen(
        onPaymentSuccessfulScreen = {},
        onBackPressed = {}
    )
}

internal val totalItems = listOf(
    OrderDetailsModel(
        image = R.drawable.traditionalmaleshs,
        productName = "Traditional F/M Uniform SHS",
        productSize = "M",
        qty = "2",
        price = 150.00.toDisplayDouble(),
        totalPrice = 300.00.toDisplayDouble()
    ),
    OrderDetailsModel(
        image = R.drawable.bgts,
        productName = "Go for the Blue and Gold T-Shirt",
        productSize = "M",
        qty = "1",
        price = 99.00.toDisplayDouble(),
        totalPrice = 99.00.toDisplayDouble()
    ),
)

internal data class OrderDetailsModel(
    @DrawableRes val image: Int,
    val productName: String,
    val productSize: String,
    val qty: String,
    val price: DisplayableNumber,
    val totalPrice: DisplayableNumber
)
