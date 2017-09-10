package net.maiatoday.mkay.db.dao

import org.junit.Test

import org.junit.Assert.*
import android.support.test.InstrumentationRegistry
import android.arch.persistence.room.Room
import net.maiatoday.mkay.db.AppDatabase
import net.maiatoday.mkay.db.entity.Location
import org.junit.Before
import org.junit.After





/**
 * Created by maia on 2017/09/10.
 */
class EntryDaoTest {

    lateinit var db: AppDatabase
    var moodId1:Long = 0
    var moodId2:Long = 0
    var entryId1:Long = 0
    var entryId2:Long = 0
    var entryId3:Long = 0
    var entryId4:Long = 0
    var entryId5:Long = 0

    @Before
    @Throws(Exception::class)
    fun setUp() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), AppDatabase::class.java).build()
        moodId1 = db.moodModel().createMood("urgh", 7)
        moodId2 = db.moodModel().createMood("yay", 8)
        entryId1 = db.entryModel().createEntry("flopsy", 7, 2, Location(18.0F,-32.0F))
        entryId2 = db.entryModel().createEntry("mopsy", 6, 10, Location(18.0F,-32.0F))
        entryId3 = db.entryModel().createEntry("cottonTail", 5, 1, Location(18.0F,-32.0F))
        entryId4 = db.entryModel().createEntry("peter", 4, 0, Location(18.0F,-32.0F))
        entryId5 = db.entryModel().createEntry("nutkin", -9, 100, Location(18.0F,-32.0F))
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
    }
    @Test
    fun getEntryWithMoods() {
        val test = db.entryModel().getEntryWithMoods(entryId1)
        assertEquals("flopsy", test.entry?.name)
        assertEquals(7, test.entry?.sentiment)
        assertEquals(2, test.moodEntryList.size)
    }

    @Test
    fun getEntryWithComments() {
        val test = db.entryModel().getEntryWithComments(entryId5)
        assertEquals("nutkin", test.entry?.name)
        assertEquals(-9, test.entry?.sentiment)
        assertEquals(3, test.comments.size)
    }

    @Test
    fun getCompleteEntry() {
        val test = db.entryModel().getCompleteEntry(entryId1)
        assertEquals("flopsy", test.entry?.name)
        assertEquals(7, test.entry?.sentiment)
        assertEquals(2, test.moodEntryList.size)
        assertEquals(2, test.comments.size)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        db.close()
    }

}