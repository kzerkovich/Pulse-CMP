package org.kzerkovich.pulse.core.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDataBaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val applicationContext = context.applicationContext
    val databaseFile = applicationContext.getDatabasePath(dbFileName)

    return Room.databaseBuilder<AppDatabase>(
        context = applicationContext,
        name = databaseFile.absolutePath
    )
}