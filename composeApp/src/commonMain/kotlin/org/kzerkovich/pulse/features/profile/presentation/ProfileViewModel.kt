package org.kzerkovich.pulse.features.profile.presentation

import org.kzerkovich.pulse.base.BaseViewModel
import org.kzerkovich.pulse.features.profile.presentation.models.ProfileAction
import org.kzerkovich.pulse.features.profile.presentation.models.ProfileEvent
import org.kzerkovich.pulse.features.profile.presentation.models.ProfileViewState

class ProfileViewModel(

) : BaseViewModel<ProfileViewState, ProfileAction, ProfileEvent>(initialState = ProfileViewState(
    name = "Natalie",
    subscribers = "5.3m subscribers",
    joinedIn = "Joined in 2017",
    isSubscribed = true
)) {
    override fun obtainEvent(viewEvent: ProfileEvent) {
        when (viewEvent) {
            is ProfileEvent.TabSelected -> viewState =
                viewState.copy(selectedTabIndex = viewEvent.selectedIndex)
        }
    }
}