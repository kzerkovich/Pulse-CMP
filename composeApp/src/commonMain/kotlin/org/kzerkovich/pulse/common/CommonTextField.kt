package org.kzerkovich.pulse.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.kzerkovich.pulse.theme.PulseTheme

@Composable
fun CommonTextField(
    text: String = "",
    hint: String = "",
    enabled: Boolean = true,
    onTextChanged: (String) -> Unit
) {
    Box(
        modifier = Modifier.height(80.dp)
    ) {
        TextField(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            enabled = enabled,
            shape = RoundedCornerShape(12.dp),
            placeholder = {
                Text(
                    text = hint,
                    color = PulseTheme.colors.tintColor.copy(alpha = 0.3f),
                    fontSize = 16.sp,
                )
            },
            textStyle = TextStyle(
                fontSize = 16.sp,
            ),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = PulseTheme.colors.secondaryBackground,
                focusedContainerColor = PulseTheme.colors.secondaryBackground,
                disabledContainerColor = PulseTheme.colors.secondaryBackground.copy(alpha = 0.3f),
                focusedTextColor = PulseTheme.colors.tintColor,
                unfocusedTextColor = PulseTheme.colors.tintColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            singleLine = false,
            maxLines = 1,
            value = text,
            onValueChange = onTextChanged
        )
    }
}