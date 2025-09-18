package org.kzerkovich.pulse.features.feed.presentation

import org.kzerkovich.pulse.base.BaseViewModel
import org.kzerkovich.pulse.features.feed.presentation.models.FeedAction
import org.kzerkovich.pulse.features.feed.presentation.models.FeedEvent
import org.kzerkovich.pulse.features.feed.presentation.models.FeedViewState
import org.kzerkovich.pulse.features.feed.ui.views.models.FilterCellModel

class FeedViewModel :
    BaseViewModel<FeedViewState, FeedAction, FeedEvent>(initialState = FeedViewState()) {

    init {
        loadScreen()
    }

    private fun loadScreen() {
        viewState = viewState.copy(
            filters = listOf(
                FilterCellModel("one", "one" == viewState.currentChipSelected),
                FilterCellModel("two", "two" == viewState.currentChipSelected),
                FilterCellModel("three", "three" == viewState.currentChipSelected),
            )
        )
    }

    override fun obtainEvent(viewEvent: FeedEvent) {
        when (viewEvent) {
            is FeedEvent.ClickItemFilter -> handleClickItemFilter(viewEvent.type)
        }
    }

    private fun handleClickItemFilter(type: String) {
        viewState = viewState.copy(currentChipSelected = type)
        loadScreen()
    }
}