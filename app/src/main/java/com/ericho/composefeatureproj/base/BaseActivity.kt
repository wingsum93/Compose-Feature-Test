package com.ericho.composefeatureproj.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.ericho.composefeatureproj.*
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener

abstract class BaseActivity : ComponentActivity(), SplitInstallStateUpdatedListener {

    lateinit var manager: SplitInstallManager
    val CONFIRMATION_REQUEST_CODE = 1

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.installActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manager = SplitInstallManagerFactory.create(this)
    }

    override fun onResume() {
        // Listener can be registered even without directly triggering a download.
        manager.registerListener(this)
        super.onResume()
    }

    override fun onPause() {
        // Make sure to dispose of the listener once it's no longer needed.
        manager.unregisterListener(this)
        super.onPause()
    }

    fun toastAndLog(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        Log.d(this::class.java.simpleName, text)
    }
}
