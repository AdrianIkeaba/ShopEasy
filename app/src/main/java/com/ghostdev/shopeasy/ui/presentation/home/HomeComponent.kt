package com.ghostdev.shopeasy.ui.presentation.home

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
fun HomeComponent(productList: List<Products>, onAddProduct: (Int) -> Unit) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(productList.size) { index ->
            ProductComponent(productList[index], onAddProduct)
        }
    }
}
