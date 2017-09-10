package net.maiatoday.mkay.db.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

/**
 * Class containing the Entry and all it's comments and all the moodIdss
 * Created by maia on 2017/09/10.
 */
data class EntryComplete(
        @Embedded
        var entry: Entry?,
        @Relation(parentColumn = "id", entityColumn = "entryId", entity = Comment::class)
        var comments: List<Comment>,
        @Relation(
                parentColumn = "id",
                entityColumn = "entryId",
                entity = EntryMood::class) var moodEntryList: List<EntryMood>) {
    constructor() : this(null, emptyList(), emptyList())
}