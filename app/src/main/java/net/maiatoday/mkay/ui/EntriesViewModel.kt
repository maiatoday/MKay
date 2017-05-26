package net.maiatoday.mkay.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import net.maiatoday.mkay.MKayApplication
import net.maiatoday.mkay.model.ApplicationDatabase
import javax.inject.Inject

/**
 * Created by maia on 2017/05/26.
 */
class EntriesViewModel constructor(application: Application) : AndroidViewModel(application) {

    @Inject lateinit var db: ApplicationDatabase

    init {
        (application as MKayApplication).appComponent.inject(this)
    }

    //TODO

}