package org.kzerkovich.pulse.features.feed.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import org.kzerkovich.pulse.features.feed.presentation.FeedViewModel

@Composable
fun FeedScreen(viewModel: FeedViewModel = viewModel {  FeedViewModel() }) {

    val viewState by viewModel.viewStates().collectAsState()

    FeedView(viewState) { event ->
        viewModel.obtainEvent(event)
    }
}