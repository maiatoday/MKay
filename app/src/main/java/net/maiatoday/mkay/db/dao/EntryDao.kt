package net.maiatoday.mkay.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import net.maiatoday.mkay.db.entity.Entry
import net.maiatoday.mkay.db.entity.Item

/**
 * Created by maia on 2017/05/25.
 */

@Dao
abstract class EntryDao {
    @Query("SELECT COUNT(*) FROM entry")
    abstract fun count(): Int

    @Query("SELECT * FROM entry")
    abstract fun getAll(): LiveData<List<Entry>>

    @Query("SELECT * FROM entry WHERE id = :id")
    abstract fun get(id: Long): Entry?

    @Query("SELECT entry.id, entry.name, mood.moodName, mood.colour FROM entry, mood " +
    "WHERE entry.moodId = mood.id")
    abstract fun loadItems(): LiveData<Item>

    fun createEntry(name: String, moodId:Long) {
        insertOrUpdate(Entry(0, name, moodId))
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOrUpdate(vararg items: Entry)

    @Delete
    abstract fun delete(item: Entry)
}
