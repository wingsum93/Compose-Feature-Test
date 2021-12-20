package com.ericho.composefeatureproj.model

import com.google.gson.annotations.SerializedName
import java.util.*

class SingleTicketResponse {
    var status: Boolean = false
    var result: Data? = null

    class Data {
        val ready: Int = 0
        var current: CurrentTicket? = null
        val hasTable: Boolean
            get() = ready >= 1
    }

    class CurrentTicket {
        val code: String = ""

        @SerializedName("create_at")
        val createAt: Date? = null
        val number: Int = 0
    }
}