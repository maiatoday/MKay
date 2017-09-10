package net.maiatoday.mkay.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Comment
 * Created by maia on 2017/09/10.
 */
@Entity(tableName = "comments")
data class Comment(@PrimaryKey(autoGenerate = true) var id: Long = 0,
                   val entryId:Long,
                   val text: String,
                   val date: Date)