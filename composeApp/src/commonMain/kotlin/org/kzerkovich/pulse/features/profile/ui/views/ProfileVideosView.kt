package org.kzerkovich.pulse.features.profile.ui.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.kzerkovich.pulse.theme.PulseTheme

@Composable
fun ProfileVideosView() {
    Text(
        text = "Hello, Videos",
        color = PulseTheme.colors.primaryText
    )
}