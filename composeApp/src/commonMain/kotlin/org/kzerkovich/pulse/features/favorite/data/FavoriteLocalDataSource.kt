package org.kzerkovich.pulse.features.favorite.data

import org.kzerkovich.pulse.core.database.AppDatabase
import org.kzerkovich.pulse.core.di.InjectProvider

interface FavoriteLocalDataSource {
    suspend fun getFavoritePosts(): List<String>
}

class FavoriteRoomDataSource(
    private val database: AppDatabase = InjectProvider.getDataBase()
) : FavoriteLocalDataSource {
    override suspend fun getFavoritePosts(): List<String> {
        return emptyList()
    }

}