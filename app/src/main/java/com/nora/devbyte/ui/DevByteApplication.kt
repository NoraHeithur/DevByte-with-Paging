package com.nora.devbyte.ui

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import com.akexorcist.localizationactivity.core.LocalizationApplicationDelegate
import com.nora.devbyte.BuildConfig
import com.nora.devbyte.di.databaseModule
import com.nora.devbyte.di.networkModule
import com.nora.devbyte.di.repositoryModule
import com.nora.devbyte.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber
import java.util.*

class DevByteApplication : Application() {

    private val localizationDelegate = LocalizationApplicationDelegate()
    private val defaultLocale = Locale.ENGLISH

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@DevByteApplication)
            androidLogger()
            modules(listOf(networkModule, databaseModule, repositoryModule, viewModelModule))
        }
    }

    override fun attachBaseContext(base: Context) {
        localizationDelegate.setDefaultLanguage(base, defaultLocale)
        super.attachBaseContext(localizationDelegate.attachBaseContext(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localizationDelegate.onConfigurationChanged(this)
    }

    override fun getApplicationContext(): Context {
        return localizationDelegate.getApplicationContext(super.getApplicationContext())
    }

    override fun getResources(): Resources {
        return localizationDelegate.getResources(this, super.getResources())
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }
}