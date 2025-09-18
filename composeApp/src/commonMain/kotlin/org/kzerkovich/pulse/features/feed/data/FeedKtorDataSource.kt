package org.kzerkovich.pulse.features.feed.data

import org.kzerkovich.pulse.core.network.DemoHttpClient
import org.kzerkovich.pulse.features.feed.data.models.KtorFeedModel

class FeedKtorDataSource(
    private val httpClient: DemoHttpClient = DemoHttpClient()
) : FeedRemoteDataSource {
    override suspend fun fetchNextChunk(
        token: String,
        postId: String,
        filters: List<String>
    ): List<KtorFeedModel> {
        return emptyList()
    }
}