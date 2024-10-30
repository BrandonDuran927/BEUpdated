package com.example.beupdated.product.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beupdated.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    onCheckoutScreen: () -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 5.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.gold).copy(alpha = 0f)
                ),
                title = {
                    Text(
                        text = "Product",
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
                containerColor = Color.Transparent,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    TextButton(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(colorResource(R.color.blue)),
                        onClick = {
                            Toast.makeText(
                                context,
                                "Successfully added to wishlist",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            imageVector = Icons.Outlined.Star,
                            contentDescription = "Wishlist Button",
                            tint = Color.White
                        )

                        Text(
                            text = "Saved to wishlist",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                    TextButton(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(colorResource(R.color.gold)),
                        onClick = {
                            onCheckoutScreen()
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            imageVector = Icons.Outlined.ShoppingCart,
                            contentDescription = "Home Button",
                            tint = Color.Black
                        )

                        Text(
                            text = "Make a reservation",
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item {
                Card(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(start = 10.dp, end = 10.dp, bottom = 20.dp),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(R.drawable.tourismsuit),
                        contentDescription = "Image of product",
                        contentScale = ContentScale.Crop
                    )
                }
            }

            item {
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = "Tourism Suit",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = "P 400.00",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light
                )
            }

            item {
                HorizontalDivider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp))
            }

            item {
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = "Stock Quantity: 80",
                    fontWeight = FontWeight.Bold
                )

                Box {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 10.dp),
                            text = "Size: S, M, L",
                            fontWeight = FontWeight.Bold
                        )
                        Icon(
                            Icons.Default.ArrowDropDown,
                            "Arrow drop down"
                        )
                    }
                    DropdownMenu(
                        expanded = false,
                        onDismissRequest = {}
                    ) {
                        DropdownMenuItem(
                            text = {
                                Text("Small")
                            },
                            onClick = {}
                        )
                    }
                }




                Spacer(Modifier.height(10.dp))

            }

            item {
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = "The Tourism Suit at National University Fairview Branch is a specialized outfit designed for tourism students. It represents professionalism and the school's commitment to grooming students for the tourism industry. The suit features a neat, modern design, and is made to be both comfortable and presentable for various activities like tours, presentations, and formal events. It emphasizes National University’s focus on aligning students with industry standards, ensuring they are ready for both academic and professional environments.",
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductScreenPrev() {
    ProductScreen(
        onBackPressed = {},
        onCheckoutScreen = {}
    )
}