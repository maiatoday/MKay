package net.maiatoday.mkay.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(
    entities = arrayOf(Entry::class, Mood::class),
    version = 1
)
abstract class ApplicationDatabase : RoomDatabase() {

  abstract fun entryModel(): EntryDao
  abstract fun moodModel(): MoodDao

  companion object {
    private const val DB_NAME = "mkay.db"

    fun createInMemoryDatabase(context: Context): ApplicationDatabase
        = Room.inMemoryDatabaseBuilder(context.applicationContext, ApplicationDatabase::class.java).build()

    fun createPersistentDatabase(context: Context): ApplicationDatabase
        = Room.databaseBuilder(context.applicationContext, ApplicationDatabase::class.java, DB_NAME).build()
  }

}