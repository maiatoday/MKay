package net.maiatoday.mkay

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by maia on 2017/05/26.
 */
class MKayApplication : Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder()
            .androidModule(AndroidModule(this))
            .build()

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }

    }
}