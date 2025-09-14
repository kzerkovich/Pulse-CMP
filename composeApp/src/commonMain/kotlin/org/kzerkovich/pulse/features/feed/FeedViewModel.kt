package org.kzerkovich.pulse.features.feed

import org.kzerkovich.pulse.base.BaseViewModel
import org.kzerkovich.pulse.features.feed.models.FeedAction
import org.kzerkovich.pulse.features.feed.models.FeedEvent
import org.kzerkovich.pulse.features.feed.models.FeedViewState

class FeedViewModel : BaseViewModel<FeedViewState, FeedAction, FeedEvent>
    (initialState = FeedViewState()) {
    override fun obtainEvent(viewEvent: FeedEvent) {

    }
}