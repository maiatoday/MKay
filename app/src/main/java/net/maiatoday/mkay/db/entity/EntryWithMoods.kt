package net.maiatoday.mkay.db.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

/**
 * Data class to allow us to fetch a list of moods for a particular entry
 * Created by maia on 2017/05/25.
 */
data class EntryWithMoods(@Embedded var entry: Entry?,
                          @Relation(
                                  parentColumn = "id",
                                  entityColumn = "entryId",
                                  entity = EntryMood::class) var moodEntryList: List<EntryMood>) {
    constructor() : this(null, emptyList())

}
