package com.ghostdev.shopeasy.ui.presentation.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ghostdev.shopeasy.data.models.Products
import com.ghostdev.shopeasy.ui.presentation.checkout.CheckoutComponent
import com.ghostdev.shopeasy.ui.presentation.home.HomeComponent
import com.ghostdev.shopeasy.ui.theme.OrderCompleteComponent

@Composable
fun BaseComponent(products: List<Products>, onAddProduct: (Int) -> Unit) {
    val statusBarInsets = WindowInsets.statusBars.asPaddingValues()
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Products", "Checkout")

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = statusBarInsets.calculateTopPadding())
                .wrapContentHeight()
                .background(Color.White)
        ) {
            Text(
                text = "KICKS",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Box(modifier = Modifier
            .weight(1f)
            .fillMaxSize()) {
            if (selectedItem == 0) {
                HomeComponent(products, onAddProduct)
            } else if (selectedItem == 1) {
                CheckoutComponent(products.filter { it.added }, onAddProduct)
            } else if (selectedItem == 2) {
                OrderCompleteComponent()
            }
        }

        if (selectedItem == 1) {
            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
                onClick = {
                    selectedItem = 2
                }
            ) {
                val addedProducts = products.filter { it.added }
                var price = 0.00
                for (product in addedProducts) {
                    price += product.product_price
                }
                Text(text = "Checkout: $$price")
            }
        }

        BottomNavigationBar(
            items = items,
            selectedItem = selectedItem,
            onItemSelected = { selectedItem = it }
        )
    }
}
