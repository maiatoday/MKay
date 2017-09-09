package net.maiatoday.mkay.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * A table that contains the entry/mood connection of a many to many relationship
 * Created by maia on 2017/09/09.
 */
@Entity(tableName = "entry_mood")
data class EntryMood(@field:PrimaryKey(autoGenerate = true) var id: Long = 0,
                     val entryId: Long,
                     val moodId: Long)