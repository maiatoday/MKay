package net.maiatoday.mkay.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import net.maiatoday.mkay.MKayApplication
import net.maiatoday.mkay.db.AppDatabase
import net.maiatoday.mkay.db.entity.Entry
import net.maiatoday.mkay.db.util.DbCreate
import javax.inject.Inject

/**
 * Created by maia on 2017/05/26.
 */
class EntriesViewModel constructor(application: Application) : AndroidViewModel(application) {

    @Inject lateinit var db: AppDatabase
    var dbCreate: DbCreate

    init {
        (application as MKayApplication).appComponent.inject(this)
        dbCreate = DbCreate(application)
        dbCreate.buildDb()
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