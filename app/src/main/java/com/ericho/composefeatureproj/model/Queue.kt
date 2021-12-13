package com.ericho.composefeatureproj.model

import com.google.gson.annotations.SerializedName

data class Queue(
    val code: String,
    val number: Int,
    @SerializedName("queue_code")
    val queueCode: String? = null
) {
}