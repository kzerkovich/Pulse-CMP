package org.kzerkovich.pulse.features.create

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.kzerkovich.pulse.features.create.models.CreatePostEvent
import org.kzerkovich.pulse.features.create.models.CreatePostViewState
import org.kzerkovich.pulse.theme.PulseTheme

@Composable
fun CreatePostView(
    viewState: CreatePostViewState,
    eventHandler: (CreatePostEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
    ) {
        Text(
            text = "Title",
            color = PulseTheme.colors.primaryText,
            fontSize = 16.sp
        )
    }
}
