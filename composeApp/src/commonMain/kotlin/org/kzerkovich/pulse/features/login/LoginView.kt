package org.kzerkovich.pulse.features.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.kzerkovich.pulse.common.textfield.CommonTextField
import org.kzerkovich.pulse.features.login.models.LoginEvent
import org.kzerkovich.pulse.features.login.models.LoginViewState
import org.kzerkovich.pulse.theme.AppTheme
import org.kzerkovich.pulse.theme.PulseTheme
import pulse.composeapp.generated.resources.Res
import pulse.composeapp.generated.resources.login_email
import pulse.composeapp.generated.resources.login_forgot_password
import pulse.composeapp.generated.resources.login_intro
import pulse.composeapp.generated.resources.login_log_in
import pulse.composeapp.generated.resources.login_password
import pulse.composeapp.generated.resources.login_register
import pulse.composeapp.generated.resources.login_sign_up
import pulse.composeapp.generated.resources.login_title
import pulse.composeapp.generated.resources.login_welcome_back

@Composable
internal fun LoginView(
    viewState: LoginViewState,
    eventHandler: (LoginEvent) -> Unit
) {
    Column {
        Box(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_title),
                color = PulseTheme.colors.primaryText,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 12.dp)
                .fillMaxWidth()
                .height(28.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_welcome_back),
                color = PulseTheme.colors.primaryText,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 4.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_intro),
                color = PulseTheme.colors.primaryText,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }

        CommonTextField(
            text = viewState.emailValue,
            hint = stringResource(Res.string.login_email),
            enabled = !viewState.isSending
        ) {
            eventHandler.invoke(LoginEvent.EmailChanged(it))
        }
        CommonTextField(
            text = viewState.passwordValue,
            hint = stringResource(Res.string.login_password),
            enabled = !viewState.isSending
        ) {
            eventHandler.invoke(LoginEvent.PasswordChanged(it))
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(156.dp, 40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable {

                    },

                ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(Res.string.login_forgot_password),
                    color = PulseTheme.colors.primaryText
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .size(84.dp, 40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable {
                        eventHandler.invoke(LoginEvent.LoginClicked)
                    },
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(Res.string.login_log_in),
                    color = PulseTheme.colors.primaryText
                )
            }

        }

        Row {
            Text(
                modifier = Modifier.padding(top = 4.dp, bottom = 12.dp, start = 16.dp),
                text = stringResource(Res.string.login_register),
                color = PulseTheme.colors.tintColor,
                fontWeight = FontWeight.Light
            )

            Text(
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 12.dp, end = 16.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable {
                        eventHandler.invoke(LoginEvent.SignUpClicked)
                    },
                text = stringResource(Res.string.login_sign_up),
                color = PulseTheme.colors.tintColor,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Preview
@Composable
internal fun LoginViewPreview() {
    AppTheme {
        LoginView(
            viewState = LoginViewState(),
            eventHandler = {}
        )
    }
}