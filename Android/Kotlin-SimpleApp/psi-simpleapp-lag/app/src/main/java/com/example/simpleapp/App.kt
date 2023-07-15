package com.example.simpleapp

import android.app.Application
import com.datadog.android.Datadog
import com.datadog.android.DatadogSite

import com.datadog.android.core.configuration.Configuration
import com.datadog.android.core.configuration.Credentials
import com.datadog.android.privacy.TrackingConsent
import com.datadog.android.rum.GlobalRum
import com.datadog.android.rum.RumMonitor
import com.datadog.android.rum.tracking.MixedViewTrackingStrategy

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        val clientToken = BuildConfig.DATADOG_CLIENT_TOKEN
        val applicationId = BuildConfig.DATADOG_APPLICATION_ID

        val environmentName = "test"
        val appVariantName = "simple-app-debug"
        val trackingConsent = TrackingConsent.GRANTED

        val configuration = Configuration.Builder(
            rumEnabled = true,
            crashReportsEnabled = true,
            tracesEnabled = true,
            logsEnabled = false
        )
            .trackInteractions()
            .trackLongTasks(100L)
            .useViewTrackingStrategy(MixedViewTrackingStrategy(true))
            .useSite(DatadogSite.US5)
            .build()

        val credentials = Credentials(clientToken,environmentName,appVariantName,applicationId)

        Datadog.initialize(this, credentials, configuration, trackingConsent)

        GlobalRum.registerIfAbsent(RumMonitor.Builder().build())
    }
}