package org.kzerkovich.pulse.features.profile.presentation.models

sealed class ProfileEvent {
    class TabSelected(val selectedIndex: Int) : ProfileEvent()
}