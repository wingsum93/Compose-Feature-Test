package com.ericho.composefeatureproj

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ericho.composefeatureproj.base.BaseActivity
import com.ericho.composefeatureproj.ui.TicketDisplayView
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import com.ericho.composefeatureproj.ui.theme.AppTheme
import com.google.android.play.core.splitinstall.SplitInstallSessionState

class MainActivity : BaseActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TicketDisplayView()
                }
            }
        }
    }

    override fun onStateUpdate(state: SplitInstallSessionState) {
        val multiInstall = state.moduleNames().size > 1
        val langsInstall = state.languages().isNotEmpty()
        val names = if (langsInstall) {
            // We always request the installation of a single language in this sample
            state.languages().first()
        } else state.moduleNames().joinToString(" - ")

        when (state.status()) {
            SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
                manager.startConfirmationDialogForResult(state, this, CONFIRMATION_REQUEST_CODE)
            }
            SplitInstallSessionStatus.INSTALLED -> {
                onSuccessfulLoad(names, launch = !multiInstall)
            }
            SplitInstallSessionStatus.FAILED -> {
                toastAndLog(
                    getString(
                        R.string.error_for_module, state.errorCode(),
                        state.moduleNames()
                    )
                )
            }
        }
    }

    private fun onSuccessfulLoad(moduleName: String, launch: Boolean) {
        if (launch) {
            when (moduleName) {
                ModuleManager.InstantModule.getDistTitle(this) -> {
                    launchActivity(ModuleManager.InstantModule.getActivityClassName())
                }
            }
        }
    }

    private fun launchActivity(className: String) {
        val intent = Intent().setClassName(BuildConfig.APPLICATION_ID, className)
        startActivity(intent)
    }
}

private const val CONFIRMATION_REQUEST_CODE = 1

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        Greeting("Android")
    }
}
