package net.maiatoday.mkay.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import net.maiatoday.mkay.MKayApplication
import net.maiatoday.mkay.db.AppDatabase
import net.maiatoday.mkay.db.entity.Entry
import net.maiatoday.mkay.db.entity.Item
import javax.inject.Inject

/**
 * Created by maia on 2017/05/26.
 */
class EntriesViewModel constructor(application: Application) : AndroidViewModel(application) {

    @Inject lateinit var db: AppDatabase
    lateinit var items: LiveData<List<Item>>

    init {
        (application as MKayApplication).appComponent.inject(this)
    }

    fun hasEntries() = db.entryModel().count() != 0

    fun entries() = db.entryModel().getAll()

    fun createEntry(name: String = "") = db.entryModel().createEntry(name)

    fun delete(counterId: Long): Entry? {
        db.entryModel().get(counterId)?.let {
            db.entryModel().delete(it)
            return it
        }
        return null
    }

}