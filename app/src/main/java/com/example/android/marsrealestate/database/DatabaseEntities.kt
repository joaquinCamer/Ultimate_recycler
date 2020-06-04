package com.example.android.marsrealestate.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.marsrealestate.network.MarsProperty
import com.squareup.moshi.Json

@Entity
data class DatabaseV constructor(
        @PrimaryKey
        val id: String,
        // used to map img_src from the JSON to imgSrcUrl in our class
        val imgSrcUrl: String,
        val type: String,
        val price: Double)


fun List<DatabaseV>.asDomainModel(): List<MarsProperty> {
    return map {
        MarsProperty(
                id = it.id,
                imgSrcUrl = it.imgSrcUrl,
                type = it.type,
                price = it.price
                )
    }
}
