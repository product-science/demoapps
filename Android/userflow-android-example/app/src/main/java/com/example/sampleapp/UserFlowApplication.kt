package com.example.sampleapp

import android.app.Application
import com.productscience.userflow.v2.UserFlow

class UserFlowApplication: Application() {
    override fun onCreate() {
        UserFlow.isRegressionAnalysisEnabled = true // to enable PS Regression Analysis feature
        UserFlow.start(APP_START_USER_FLOW_ID) // Mark user flow start
        super.onCreate()
    }

}