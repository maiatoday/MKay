package net.danlew.counter.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import net.maiatoday.mkay.model.Mood
import net.maiatoday.mkay.model.Entry
import net.maiatoday.mkay.model.EntryDao
import net.maiatoday.mkay.model.MoodDao

@Database(
    entities = arrayOf(Entry::class, Mood::class),
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

  abstract fun entryModel(): EntryDao
  abstract fun moodModel(): MoodDao

  companion object {
    private const val DB_NAME = "mkay.db"

    fun createInMemoryDatabase(context: Context): AppDatabase
        = Room.inMemoryDatabaseBuilder(context.applicationContext, AppDatabase::class.java).build()

    fun createPersistentDatabase(context: Context): AppDatabase
        = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME).build()
  }

}