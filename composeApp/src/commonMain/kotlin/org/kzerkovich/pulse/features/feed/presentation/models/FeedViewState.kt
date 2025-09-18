package org.kzerkovich.pulse.features.feed.presentation.models

import org.kzerkovich.pulse.features.feed.presentation.views.FeedCellModel

data class FeedViewState(
    val feed: List<FeedCellModel> = emptyList(),
    val filters: List<String> = emptyList()
)