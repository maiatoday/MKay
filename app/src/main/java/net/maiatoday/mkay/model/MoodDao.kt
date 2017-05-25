package net.maiatoday.mkay.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOrUpdate(vararg items: Mood)

    @Delete
    abstract fun delete(item: Mood)
}
