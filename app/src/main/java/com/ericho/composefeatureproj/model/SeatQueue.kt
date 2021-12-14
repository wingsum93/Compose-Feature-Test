package com.ericho.composefeatureproj.model

import androidx.annotation.DrawableRes

class SeatQueue(
    var title: String = "",
    @DrawableRes
    val pic: Int = 0
) {

    var remainingPosition: Int = 0


}