package net.maiatoday.mkay.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import net.maiatoday.mkay.db.entity.EntryMood

/**
 * Created by maia on 2017/09/09.
 */

@Dao
abstract class EntryMoodDao {
    @Query("SELECT COUNT(*) FROM entry_mood")
    abstract fun count(): Int

    @Query("SELECT * FROM entry_mood")
    abstract fun getAll(): LiveData<List<EntryMood>>

    @Query("SELECT * FROM entry_mood WHERE id = :id")
    abstract fun get(id: Long): EntryMood?

    @Query("SELECT * FROM entry_mood WHERE entryId = :entryId")
    abstract fun getAllForEntry(entryId: Long): List<EntryMood>

    @Query("SELECT * FROM entry_mood WHERE moodId = :moodId")
    abstract fun getAllForMood(moodId: Long): List<EntryMood>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOrUpdate(vararg items: EntryMood): List<Long>

    @Delete
    abstract fun delete(item: EntryMood)

    fun addMoodToEntry(entryId:Long, moodId:Long) {
        insertOrUpdate(EntryMood(entryId=entryId, moodId=moodId))
    }

}
