package net.maiatoday.mkay.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.ForeignKey.RESTRICT
import android.arch.persistence.room.PrimaryKey

/**
 * Created by maia on 2017/05/25.
 */

@Entity(
        tableName = "entry",
        foreignKeys = arrayOf(ForeignKey(
                entity = Mood::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("moodId"),
                onDelete = RESTRICT,
                onUpdate = CASCADE))
)
data class Entry (
        @PrimaryKey(autoGenerate = true) val id: Long,
        val name: String = "",
        val moodId: Long = 0,
        val sentiment: Int = 0,
        val energy: Int = 0,
        @Embedded val location: Location = Location(0.0F, 0.0F)
)