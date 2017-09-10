package net.maiatoday.mkay.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import net.maiatoday.mkay.db.entity.Comment
import net.maiatoday.mkay.db.entity.Entry
import net.maiatoday.mkay.db.entity.Location
import java.util.*

/**
 * Created by maia on 2017/05/25.
 */

@Dao
abstract class CommentDao {
    @Query("SELECT COUNT(*) FROM comments")
    abstract fun count(): Int

    @Query("SELECT * FROM comments")
    abstract fun getAll(): LiveData<List<Comment>>

    @Query("SELECT * FROM comments WHERE id = :id")
    abstract fun get(id: Long): Comment?

//    @Query("SELECT * FROM entries")
//    abstract fun loadEntriesWithMoods(): List<EntryWithMoods>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOrUpdate(vararg items: Comment): List<Long>

    @Delete
    abstract fun delete(item: Comment)

    fun addCommentToEntry(entryId:Long, comment: String):  Long {
        return insertOrUpdate(Comment(text = comment, entryId = entryId, date=Date())).get(0)
    }
}