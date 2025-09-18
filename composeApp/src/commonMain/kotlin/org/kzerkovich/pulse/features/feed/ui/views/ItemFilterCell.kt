package org.kzerkovich.pulse.features.feed.ui.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.kzerkovich.pulse.PulseApp
import org.kzerkovich.pulse.features.feed.ui.views.models.FilterCellModel
import org.kzerkovich.pulse.theme.PulseTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemFilterCell(filterCellModel: FilterCellModel, onClick: () -> Unit) {

    Chip(
        modifier = Modifier.padding(horizontal = 6.dp),
        onClick = onClick,
        colors = ChipDefaults.chipColors(
            backgroundColor =
                if (filterCellModel.isSelected)
                    PulseTheme.colors.tintColor
                else
                    PulseTheme.colors.secondaryBackground
        )
    ) {

        Text(
            text = filterCellModel.text,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = PulseTheme.colors.primaryText
        )
    }
}