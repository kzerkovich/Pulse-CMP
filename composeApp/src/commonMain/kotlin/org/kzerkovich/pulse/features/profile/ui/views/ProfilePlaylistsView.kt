package org.kzerkovich.pulse.features.profile.ui.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.kzerkovich.pulse.theme.PulseTheme

@Composable
fun ProfilePlaylistsView() {
    Text(
        text = "Hello, Playlists",
        color = PulseTheme.colors.primaryText
    )
}