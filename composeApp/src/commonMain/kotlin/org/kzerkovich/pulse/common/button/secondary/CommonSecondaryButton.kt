package org.kzerkovich.pulse.common.button.secondary

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.kzerkovich.pulse.theme.AppTheme
import org.kzerkovich.pulse.theme.PulseTheme


@Composable
fun CommonSecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.height(40.dp),
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = PulseTheme.colors.secondaryBackground,
            disabledBackgroundColor = PulseTheme.colors.secondaryBackground
        )
    ) {
        Text(
            text = text,
            color = if (enabled) PulseTheme.colors.primaryText else PulseTheme.colors.tintColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview
private fun ProfileViewPreview() {
    AppTheme {
        CommonSecondaryButton(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            text = "Subscribe",
        ) {

        }
    }
}