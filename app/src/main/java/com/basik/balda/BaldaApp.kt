package com.basik.balda

import android.app.Application
import com.basik.balda.di.AppComponent
import com.basik.balda.di.AppModule
import com.basik.balda.di.DaggerAppComponent

class BaldaApp: Application() {

    companion object {
        var instance: BaldaApp? = null
            private set
    }

    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this, this))
            .build()
    }
}