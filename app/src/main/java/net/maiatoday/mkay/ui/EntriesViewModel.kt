package net.maiatoday.mkay.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import net.maiatoday.mkay.MKayApplication
import net.maiatoday.mkay.db.AppDatabase
import net.maiatoday.mkay.db.entity.Entry
import javax.inject.Inject

/**
 * Created by maia on 2017/05/26.
 */
class EntriesViewModel constructor(application: Application) : AndroidViewModel(application) {

    @Inject lateinit var db: AppDatabase

    init {
        (application as MKayApplication).appComponent.inject(this)
    }

    fun hasEntries() = db.entryModel().count() != 0

    fun entries() = db.entryModel().getAll()

    fun delete(counterId: Long): Entry? {
        db.entryModel().get(counterId)?.let {
            db.entryModel().delete(it)
            return it
        }
        return null
    }

}