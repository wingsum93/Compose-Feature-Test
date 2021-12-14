package com.ericho.composefeatureproj.model

class SingleTicketResponse {
    var status: Boolean = false
    var result: Data? = null

    class Data {
        val ready: Int = 1
        val hasTable: Boolean
            get() = ready == 1
    }
}