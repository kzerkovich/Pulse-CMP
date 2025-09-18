package org.kzerkovich.pulse.features.feed.presentation.models

import org.kzerkovich.pulse.features.feed.ui.views.models.FeedCellModel
import org.kzerkovich.pulse.features.feed.ui.views.models.FilterCellModel

data class FeedViewState (
    val iconAvatar: String = "",
    val title :String = "",
    val filters: List<FilterCellModel> = emptyList(),
    val feedCellModel: List<FeedCellModel> = listOf(
        FeedCellModel(
            title = "A Day in My Life: LA Edition",
            subTitle = "Trending",
            count = "6 videos 1 post",
        ),
        FeedCellModel(
            title = "A Day in My Life: LA Edition1",
            subTitle = "Trending1",
            count = "6 videos 1 post1",
        )
    ),
    val currentChipSelected: String? = null
)