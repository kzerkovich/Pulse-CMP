package org.kzerkovich.pulse.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.kzerkovich.pulse.features.draft.data.DraftDAO
import org.kzerkovich.pulse.features.draft.data.DraftEntity

@Database(entities = [DraftEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDraftDao(): DraftDAO
}

internal const val dbFileName = "appPulse.db"