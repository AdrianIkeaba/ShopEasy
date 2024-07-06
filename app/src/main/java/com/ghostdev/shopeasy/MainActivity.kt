package com.ghostdev.shopeasy

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import com.ghostdev.shopeasy.data.models.Products
import com.ghostdev.shopeasy.ui.presentation.base.BaseComponent
import com.ghostdev.shopeasy.ui.theme.ShopEasyTheme
import com.ghostdev.shopeasy.utilities.images.bitmapToByteArray
import com.ghostdev.shopeasy.utilities.images.drawableToBitmap

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.statusBarColor = Color.White.toArgb()
        window.decorView.getWindowInsetsController()!!
            .setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS)
        setContent {
            ShopEasyApp()
        }
    }
}

@Composable
fun ShopEasyApp() {
    val context = LocalContext.current.applicationContext
    ShopEasyTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            var products by remember {
                mutableStateOf(
                    listOf(
                        Products(
                            0,
                            "Adidas Shoes",
                            "Running shoes for professionals made by Adidas",
                            120.00,
                            bitmapToByteArray(drawableToBitmap(context, R.drawable.shoe_1)!!),
                            false
                        ),
                        Products(
                            1,
                            "Fila Shoes",
                            "Fila shoes for work",
                            100.00,
                            bitmapToByteArray(drawableToBitmap(context, R.drawable.shoe_2)!!),
                            false
                        ),
                        Products(
                            2,
                            "Red generic leather shoe",
                            "Red leather shoe for everyday wear",
                            190.00,
                            bitmapToByteArray(drawableToBitmap(context, R.drawable.shoe_3)!!),
                            false
                        ),
                        Products(
                            3,
                            "White sports shoe",
                            "Great sports shoe for causal wear",
                            80.00,
                            bitmapToByteArray(drawableToBitmap(context, R.drawable.shoe_4)!!),
                            false
                        ),
                        Products(
                            4,
                            "Black shoes",
                            "Generic black shoe.",
                            50.00,
                            bitmapToByteArray(drawableToBitmap(context, R.drawable.shoe_5)!!),
                            false
                        ),
                        Products(
                            5,
                            "High-top sneakers",
                            "High-top sneakers for work and events.",
                            200.00,
                            bitmapToByteArray(drawableToBitmap(context, R.drawable.shoe_6)!!),
                            false
                        ),
                        Products(
                            6,
                            "Black sports shoe",
                            "Black sports shoe for causal wear",
                            250.00,
                            bitmapToByteArray(drawableToBitmap(context, R.drawable.shoe_7)!!),
                            false
                        )
                    )
                )
            }

            BaseComponent(products) { productId ->
                products = products.map {
                    if (it.id == productId) {
                        it.copy(added = !it.added)
                    } else {
                        it
                    }
                }
            }
        }
    }
}
