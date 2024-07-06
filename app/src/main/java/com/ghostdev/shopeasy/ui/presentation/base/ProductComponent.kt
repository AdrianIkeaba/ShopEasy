package com.ghostdev.shopeasy.ui.presentation.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ghostdev.shopeasy.data.models.Products
import com.ghostdev.shopeasy.utilities.images.byteArrayToBitmap

@Composable
fun ProductComponent(product: Products, onAddProduct: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .wrapContentHeight()
            .width(200.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Column(
            modifier = Modifier.wrapContentHeight()
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder, contentDescription = "Favourite",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(12.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    bitmap = byteArrayToBitmap(product.product_image).asImageBitmap(),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .size(150.dp)
                        .align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = product.product_name,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = product.product_info, modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                fontSize = 13.sp, textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$${product.product_price}",
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .align(Alignment.CenterVertically),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Blue
                )

                TextButton(
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .height(30.dp),
                    onClick = { onAddProduct(product.id) },
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = if (product.added) Color.Green else Color(0xFFC9E4FE)
                    ),
                    contentPadding = PaddingValues()
                ) {
                    Text(text = if (product.added) "Added" else "Add", color = Color.Black, fontSize = 11.sp)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}
