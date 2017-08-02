package net.maiatoday.mkay.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import net.maiatoday.mkay.db.entity.Mood

/**
 * Created by maia on 2017/05/25.
 */
@Dao
abstract class MoodDao {
    @Query("SELECT COUNT(*) FROM mood")
    abstract fun count(): Int

    @Query("SELECT * FROM mood")
    abstract fun getAll(): LiveData<List<Mood>>

    @Query("SELECT * FROM mood WHERE id = :id")
    abstract fun get(id: Long): Mood?

    fun createMood(name: String, moodId:Long) {
        insertOrUpdate(Mood(id=moodId, moodName=name))
    }
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOrUpdate(vararg items: Mood)

    @Delete
    abstract fun delete(item: Mood)
}
