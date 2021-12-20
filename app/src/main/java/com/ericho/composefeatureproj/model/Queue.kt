package com.ericho.composefeatureproj.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Queue(
    val code: String,
    val number: Int,
    @SerializedName("queue_code")
    val queueCode: String? = null,
    @SerializedName("create_at")
    val createAt: Date? = null
) {
}