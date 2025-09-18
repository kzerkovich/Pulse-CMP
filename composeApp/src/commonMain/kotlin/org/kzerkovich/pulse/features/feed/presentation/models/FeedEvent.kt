package org.kzerkovich.pulse.features.feed.presentation.models

sealed class FeedEvent {
    class PostClicked(val postId: String) : FeedEvent()

    class FilterClicked(val filterId: String) : FeedEvent()

    data object UserClicked : FeedEvent()
    data object LoadMore : FeedEvent()
}