package com.example.android.marsrealestate.network

import com.example.android.marsrealestate.database.DatabaseV
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NetworkVideoContainer(val video: List<NetworkV>)

@JsonClass(generateAdapter = true)
data class NetworkV(
        val id: String,
        // used to map img_src from the JSON to imgSrcUrl in our class
        val imgSrcUrl: String,
        val type: String,
        val price: Double)


fun NetworkVideoContainer.asDomainModel(): List<MarsProperty> {
    return video.map {
        MarsProperty(id = it.id,
                imgSrcUrl = it.imgSrcUrl,
                type = it.type,
                price = it.price
                )
    }
}





fun NetworkVideoContainer.asDatabaseModel(): Array<DatabaseV> {
    return video.map {
        DatabaseV (
                id = it.id,
                imgSrcUrl = it.imgSrcUrl,
                type = it.type,
                price = it.price)
    }.toTypedArray()
}