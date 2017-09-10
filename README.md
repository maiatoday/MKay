# MKay Hmm-'kay
`how are u?` `mkay`

Mood tracker app to explore room and new app architecture.

DB has the following tables/entities

1. Entry(table=entries) contains the mood tracking entries. Each entry has a title, a location, a timestamp and more. One entry can have many moods associated with it. One entry can also have many comments.
2. Mood(table=moods) contains a record of a mood and an associated colour. One mood can appear in many entries if the mood is recurring.
3. EntryMood(table=entry_mood) this is just the connecting table to describe the many to many relationship among moods and entries.
4. Comment(table=comments) a separate table recording all the comments and the timestamp that it was recorded. An Entry can have multiple comments but a Comment only belongs to one Entry.

There are tests in EntryDaoTest and MoodDaoTest which shows how this works.

The app uses dagger and the db is injected as a singleton.

From the EntryDao you can get an Entry with all its comments and its moods using the @Relation annotation and the EntryComplete class. I have not found a way to get a list of the actual moods rather than the mood ids.
