package net.maiatoday.mkay.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import net.maiatoday.mkay.db.entity.Mood

/**
 * Created by maia on 2017/05/25.
 */
@Dao
abstract class MoodDao {
    @Query("SELECT COUNT(*) FROM moods")
    abstract fun count(): Int

    @Query("SELECT * FROM moods")
    abstract fun getAll(): LiveData<List<Mood>>

    @Query("SELECT * FROM moods WHERE id = :id")
    abstract fun get(id: Long): Mood?

//    @Query("SELECT * FROM moods")
//    abstract fun loadMoodsWithEntries(): List<MoodWithEntries>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOrUpdate(vararg items: Mood):  List<Long>

    @Delete
    abstract fun delete(item: Mood)

    fun createMood(name:String, colour:Int):  Long {
        return insertOrUpdate(Mood(moodName=name, colour=colour)).get(0)
    }
}
