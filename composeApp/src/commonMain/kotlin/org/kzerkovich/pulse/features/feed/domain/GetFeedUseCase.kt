package org.kzerkovich.pulse.features.feed.domain

import org.kzerkovich.pulse.features.favorite.data.FavoriteLocalDataSource
import org.kzerkovich.pulse.features.favorite.data.FavoriteRoomDataSource
import org.kzerkovich.pulse.features.feed.data.FeedKtorDataSource
import org.kzerkovich.pulse.features.feed.data.FeedRemoteDataSource
import org.kzerkovich.pulse.features.feed.domain.models.Feed
import org.kzerkovich.pulse.features.feed.domain.models.mapToFeed
import org.kzerkovich.pulse.features.login.data.AuthEncryptedDataSource
import org.kzerkovich.pulse.features.login.data.AuthLocalDataStore

class GetFeedUseCase(
    private val authLocalDataStore: AuthLocalDataStore = AuthEncryptedDataSource(),
    private val favoriteLocalDataSource: FavoriteLocalDataSource = FavoriteRoomDataSource(),
    private val feedRemoteDataSource: FeedRemoteDataSource = FeedKtorDataSource()
) {
    suspend fun execute(): List<Feed> {
        val token = authLocalDataStore.checkToken()
        val favorites = favoriteLocalDataSource.getFavoritePosts()
        val feed =
            feedRemoteDataSource.fetchNextChunk(token = token, postId = "", filters = emptyList())
                .map {
                    it.mapToFeed(isFavorite = favorites.contains(it.postId))
                }

        return feed
    }
}
