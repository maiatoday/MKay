package net.maiatoday.mkay.db.util

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import net.maiatoday.mkay.MKayApplication
import net.maiatoday.mkay.db.AppDatabase
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
        val buildDbTask = object : AsyncTask<Context, Void?, Void?>() {

            override fun doInBackground(vararg params: Context): Void? {
                Log.d("DatabaseCreator",
                        "Starting bg job " + Thread.currentThread().name)

                val context = params[0].applicationContext

                // Reset the database to have new data on every run.
                context.deleteDatabase(AppDatabase.DB_NAME)

                // Build the database!
                val db = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, AppDatabase.DB_NAME).build()

                // Add some data to the database
              //  DatabaseInitUtil.initializeDb(db)
                db.moodModel().createMood("urgh", 7)
                db.entryModel().createEntry("flopsy", 7)
                db.entryModel().createEntry("mopsy", 7)
                db.entryModel().createEntry("cotton-tail", 7)
                db.entryModel().createEntry("peter", 7)
                db.entryModel().createEntry("nutkin", 7)
                Log.d("DatabaseCreator",
                        "DB was populated in thread " + Thread.currentThread().name)


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