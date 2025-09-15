package org.kzerkovich.pulse.features.draft.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.kzerkovich.pulse.features.draft.data.DraftEntity

@Dao
interface DraftDAO {

    @Query("SELECT * FROM DraftEntity")
    suspend fun getAll(): List<DraftEntity>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(item: DraftEntity)
}