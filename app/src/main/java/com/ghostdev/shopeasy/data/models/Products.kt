package com.ghostdev.shopeasy.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "checkout_table")
data class Products(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "productName")
    val product_name: String,

    @ColumnInfo(name = "productInfo")
    val product_info: String,

    @ColumnInfo(name = "productPrice")
    val product_price: Double,

    @ColumnInfo(name = "productImage")
    val product_image: ByteArray,

    @ColumnInfo(name = "added")
    val added: Boolean

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Products

        if (id != other.id) return false
        if (product_name != other.product_name) return false
        if (product_info != other.product_info) return false
        if (product_price != other.product_price) return false
        if (!product_image.contentEquals(other.product_image)) return false
        if (added != other.added) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + product_name.hashCode()
        result = 31 * result + product_info.hashCode()
        result = 31 * result + product_price.hashCode()
        result = 31 * result + product_image.contentHashCode()
        result = 31 * result + added.hashCode()
        return result
    }
}