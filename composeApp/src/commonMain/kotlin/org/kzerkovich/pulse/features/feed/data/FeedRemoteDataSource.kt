package org.kzerkovich.pulse.features.feed.data

import org.kzerkovich.pulse.features.feed.data.models.KtorFeedModel

interface FeedRemoteDataSource {
    suspend fun fetchNextChunk(token: String, postId: String, filters: List<String>): List<KtorFeedModel>
}