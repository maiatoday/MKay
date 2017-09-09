package net.maiatoday.mkay.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Basic mood class. It has a name and a colour
 * Created by maia on 2017/05/25.
 */
@Entity(tableName = "moods")
data class Mood(@PrimaryKey(autoGenerate = true) var id: Long = 0,
           val moodName: String,
           val colour: Int)