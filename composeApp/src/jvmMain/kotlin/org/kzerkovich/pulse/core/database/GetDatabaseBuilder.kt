package org.kzerkovich.pulse.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

fun getDataBaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), dbFileName)

    return Room.databaseBuilder<AppDatabase>(
        name = dbFile.absolutePath
    )
}