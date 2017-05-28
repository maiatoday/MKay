package net.maiatoday.mkay.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by maia on 2017/05/25.
 */
@Entity(
        tableName = "mood"
)
data class Mood (
        @PrimaryKey(autoGenerate = true) val id: Long,
        val moodName: String = "",
        val colour: Int = 0
)