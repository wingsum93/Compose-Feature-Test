package com.ericho.composefeatureproj

import android.content.Context

sealed class ModuleManager(private val distTitleID: Int, private val className: String) {

    object InstantModule :
        ModuleManager(R.string.title_restaurant_queue, "com.ericho.restaurant_queue.PullActivity")

   internal fun getDistTitle(ctx: Context?): String? = ctx?.getString(distTitleID)
   internal fun getActivityClassName():String = className
}