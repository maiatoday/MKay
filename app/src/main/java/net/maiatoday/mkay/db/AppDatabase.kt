package net.maiatoday.mkay.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import net.maiatoday.mkay.db.converter.DateConverter
import net.maiatoday.mkay.db.dao.EntryDao
import net.maiatoday.mkay.db.dao.MoodDao
import net.maiatoday.mkay.db.entity.Entry
import net.maiatoday.mkay.db.entity.Mood

@Database(
    entities = arrayOf(Entry::class, Mood::class),
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

  abstract fun entryModel(): EntryDao
  abstract fun moodModel(): MoodDao

  companion object {
    const val DB_NAME = "mkay.db"

    fun createInMemoryDatabase(context: Context): AppDatabase
        = Room.inMemoryDatabaseBuilder(context.applicationContext, AppDatabase::class.java).build()

    fun createPersistentDatabase(context: Context): AppDatabase
        = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME).build()
  }

}