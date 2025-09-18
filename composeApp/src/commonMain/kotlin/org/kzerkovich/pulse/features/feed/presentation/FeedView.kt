package org.kzerkovich.pulse.features.feed.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import org.kzerkovich.pulse.features.feed.presentation.models.FeedEvent
import org.kzerkovich.pulse.features.feed.presentation.models.FeedViewState
import org.kzerkovich.pulse.features.feed.presentation.views.FeedCell

@Composable
fun FeedView(viewState: FeedViewState, eventHandler: (FeedEvent) -> Unit) {
    LazyColumn {
        items(viewState.feed) { model ->
            FeedCell(model)
        }
    }
}