package net.maiatoday.mkay.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import net.maiatoday.mkay.db.entity.*
import java.util.*

/**
 * Created by maia on 2017/05/25.
 */

@Dao
abstract class EntryDao {
    @Query("SELECT COUNT(*) FROM entries")
    abstract fun count(): Int

    @Query("SELECT * FROM entries")
    abstract fun getAll(): LiveData<List<Entry>>

    @Query("SELECT * FROM entries WHERE id = :id")
    abstract fun get(id: Long): Entry?

    @Query("SELECT * FROM entries WHERE id = :id")
    abstract fun getEntryWithMoods(id: Long): EntryWithMoods

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOrUpdate(vararg items: Entry): List<Long>

    @Delete
    abstract fun delete(item: Entry)

    fun createEntry(name: String, sentiment: Int, energy: Int, location: Location):  Long {
        return insertOrUpdate(Entry(name=name,sentiment=sentiment, energy=energy, date=Date(), location=location)).get(0)
    }

    @Query("SELECT * FROM entries WHERE id = :id")
    abstract fun getEntryWithComments(id: Long): EntryAllComments

    @Query("SELECT * FROM entries WHERE id = :id")
    abstract fun getCompleteEntry(id: Long): EntryComplete
}

