package net.maiatoday.mkay.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Created by maia on 2017/05/25.
 */

@Dao
abstract class EntryDao {
    @Query("SELECT COUNT(*) FROM entry")
    abstract fun count(): Int

    @Query("SELECT * FROM entry")
    abstract fun getAll(): LiveData<List<Entry>>

    @Query("SELECT * FROM entry WHERE id = :p0") //kapt only works if I use p0
    abstract fun get(id: Long): Entry?

    @Query("SELECT entry.id, entry.name, mood.moodName, mood.colour FROM entry, mood " +
    "WHERE entry.moodId = mood.id")
    abstract fun loadItems(): LiveData<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOrUpdate(vararg items: Entry)

    @Delete
    abstract fun delete(item: Entry)
}
