package org.kzerkovich.pulse.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory

fun getDataBaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFilePath = NSHomeDirectory() + "/${dbFileName}"
    
    return Room.databaseBuilder<AppDatabase>(
        name = dbFileName,
        factory = {
            AppDatabase::class.instantiateImpl()
        }
    )
}