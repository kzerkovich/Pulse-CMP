package org.kzerkovich.pulse.features.feed.presentation.models

sealed class FeedEvent{
    class ClickItemFilter(val type: String) : FeedEvent()
}