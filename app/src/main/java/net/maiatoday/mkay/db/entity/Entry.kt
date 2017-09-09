package net.maiatoday.mkay.db.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by maia on 2017/05/25.
 */

@Entity(tableName = "entries")
data class Entry(@PrimaryKey(autoGenerate = true) var id: Long = 0,
                 val name: String,
                 val sentiment: Int,
                 val energy: Int,
                 val date: Date,
                 @Embedded val location: Location)