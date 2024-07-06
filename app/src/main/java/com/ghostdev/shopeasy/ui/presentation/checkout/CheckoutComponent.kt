package com.ghostdev.shopeasy.ui.presentation.checkout

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ghostdev.shopeasy.data.models.Products
import com.ghostdev.shopeasy.ui.presentation.base.ProductComponent

@Composable
fun CheckoutComponent(checkoutProductList: List<Products>, onProductClick: (Int) -> Unit) {
    Log.d("items", checkoutProductList.toString())

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(checkoutProductList.size) { index ->
            ProductComponent(checkoutProductList[index], onProductClick)
        }
    }
}
