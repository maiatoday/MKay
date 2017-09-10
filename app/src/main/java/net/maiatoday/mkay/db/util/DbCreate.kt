package net.maiatoday.mkay.db.util

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import net.maiatoday.mkay.MKayApplication
import net.maiatoday.mkay.db.AppDatabase
import net.maiatoday.mkay.db.entity.Location
import javax.inject.Inject

/**
 * Created by maia on 2017/05/28.
 */
class DbCreate constructor(application: Application) {

    @Inject lateinit var db: AppDatabase
    @Inject lateinit var context: Context

    init {
        (application as MKayApplication).appComponent.inject(this)
    }


    fun buildDb() {
        val buildDbTask: AsyncTask<Context, Void?, Void?>
        buildDbTask = object : AsyncTask<Context, Void?, Void?>() {

            override fun doInBackground(vararg params: Context): Void? {
                Log.d("DatabaseCreator",
                        "Starting bg job " + Thread.currentThread().name)

                val context = params[0].applicationContext

                // Reset the database to have new data on every run.
                context.deleteDatabase(AppDatabase.DB_NAME)

                // Build the database!
                val db = AppDatabase.getInstance(context)

                // Add some data to the database
                //  DatabaseInitUtil.initializeDb(db)

                val moodId1 = db.moodModel().createMood("urgh", 7)
                val moodId2 = db.moodModel().createMood("yay", 8)
                val entryId1 = db.entryModel().createEntry("flopsy", 7, 2, Location(18.0F,-32.0F))
                val entryId2 = db.entryModel().createEntry("mopsy", 6, 10, Location(18.0F,-32.0F))
                val entryId3 = db.entryModel().createEntry("cottonTail", 5, 1, Location(18.0F,-32.0F))
                val entryId4 = db.entryModel().createEntry("peter", 4, 0, Location(18.0F,-32.0F))
                val entryId5 = db.entryModel().createEntry("nutkin", -9, 100, Location(18.0F,-32.0F))
                db.entryMoodModel().addMoodToEntry(entryId1, moodId1)
                db.entryMoodModel().addMoodToEntry(entryId1, moodId2)
                db.entryMoodModel().addMoodToEntry(entryId2, moodId1)
                db.entryMoodModel().addMoodToEntry(entryId3, moodId1)
                db.entryMoodModel().addMoodToEntry(entryId4, moodId2)
                db.entryMoodModel().addMoodToEntry(entryId5, moodId2)
                db.commentModel().addCommentToEntry(entryId1, "Hrmph_Hello")
                db.commentModel().addCommentToEntry(entryId1, "...cough...Hello")
                db.commentModel().addCommentToEntry(entryId5, "Hello")
                db.commentModel().addCommentToEntry(entryId5, "World")
                db.commentModel().addCommentToEntry(entryId5, "Sigh")
                db.commentModel().addCommentToEntry(entryId4, "Eat a banana")

                Log.d("DatabaseCreator",
                        "DB was populated in thread " + Thread.currentThread().name)

                val test = db.entryModel().getEntryWithComments(entryId5)

                Log.d("DatabaseCreator", test.toString())

                val test2 = db.entryModel().getEntryWithMoods(entryId1)

                Log.d("DatabaseCreator", test2.toString())


                val test3 = db.entryModel().getCompleteEntry(entryId1)

                Log.d("DatabaseCreator", test3.toString())


                return null
            }

            override fun onPostExecute(ignored: Void?) {
                // Now on the main thread, notify observers that the db is created and ready.
                // mIsDatabaseCreated.setValue(true)
            }
        }
        buildDbTask.execute(context.applicationContext)

    }
}