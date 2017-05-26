package net.maiatoday.mkay

import android.app.Application

/**
 * Created by maia on 2017/05/26.
 */
class MKayApplication : Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder()
            .androidModule(AndroidModule(this))
            .build()

}