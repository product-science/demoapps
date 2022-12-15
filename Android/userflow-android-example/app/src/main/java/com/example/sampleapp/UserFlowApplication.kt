package com.example.sampleapp

import android.app.Application
import com.productscience.userflow.UserFlow

class UserFlowApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        UserFlow.start(APP_START, "App start initiated")
    }

}