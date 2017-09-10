package net.maiatoday.mkay.db.entity

/**
 * Created by maia on 2017/09/09.
 */
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

/**
 * Data class to allow us to fetch a list entries for a particular mood
 * Created by maia on 2017/05/25.
 */

data class MoodWithEntries(@Embedded var mood: Mood?,
                          @Relation(
                                  parentColumn = "id",
                                  entityColumn = "moodId",
                                  entity = EntryMood::class) var moodEntryList: List<EntryMood>) {
    constructor() : this(null, emptyList())

}