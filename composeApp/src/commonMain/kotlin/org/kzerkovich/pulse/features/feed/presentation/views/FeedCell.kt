package org.kzerkovich.pulse.features.feed.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class FeedCellModel(
    val postId: String,
    val imageUrl: String,
    val title: String,
    val category: String,
    val socialInfo: String,
    val hasBlur: Boolean
)

@Composable
fun FeedCell(model: FeedCellModel) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = model.title)
        Text(text = model.category)
        Text(text = model.socialInfo)
    }
}