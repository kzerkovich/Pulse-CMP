package org.kzerkovich.pulse.features.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.kzerkovich.pulse.common.button.secondary.CommonSecondaryButton
import org.kzerkovich.pulse.features.profile.presentation.models.ProfileEvent
import org.kzerkovich.pulse.features.profile.presentation.models.ProfileViewState
import org.kzerkovich.pulse.features.profile.ui.views.ProfileAboutView
import org.kzerkovich.pulse.features.profile.ui.views.ProfilePlaylistsView
import org.kzerkovich.pulse.features.profile.ui.views.ProfileTabsView
import org.kzerkovich.pulse.features.profile.ui.views.ProfileVideosView
import org.kzerkovich.pulse.theme.AppTheme
import org.kzerkovich.pulse.theme.PulseTheme
import pulse.composeapp.generated.resources.Res
import pulse.composeapp.generated.resources.profile_about
import pulse.composeapp.generated.resources.profile_playlists
import pulse.composeapp.generated.resources.profile_subscribe
import pulse.composeapp.generated.resources.profile_subscribed
import pulse.composeapp.generated.resources.profile_title
import pulse.composeapp.generated.resources.profile_videos

@Composable
fun ProfileView(
    viewState: ProfileViewState,
    eventHandler: (ProfileEvent) -> Unit
) {
    LazyColumn(

    ) {
        stickyHeader {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.profile_title),
                    color = PulseTheme.colors.primaryText,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .clip(RoundedCornerShape(64.dp))
                    .size(128.dp)
                    .background(Color.White)
            )

            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = viewState.name,
                    color = PulseTheme.colors.primaryText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
                Text(
                    text = viewState.subscribers,
                    color = PulseTheme.colors.tintColor,
                    fontSize = 16.sp
                )
                Text(
                    text = viewState.joinedIn,
                    color = PulseTheme.colors.tintColor,
                    fontSize = 16.sp
                )
            }
        }


        if (viewState.isSubscribed != null) {
            item {
                CommonSecondaryButton(
                    modifier = Modifier
                        .padding(all = 16.dp)
                        .fillMaxWidth(),
                    text = stringResource(
                        if (!viewState.isSubscribed) Res.string.profile_subscribe
                        else Res.string.profile_subscribed
                    )
                ) {

                }
            }
        }

        item {
            ProfileTabsView(
                items = listOf(
                    stringResource(Res.string.profile_videos),
                    stringResource(Res.string.profile_playlists),
                    stringResource(Res.string.profile_about)
                ),
                selectedIndex = viewState.selectedTabIndex
            ) {
                eventHandler.invoke(ProfileEvent.TabSelected(it))
            }
        }

        item {
            Box(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth()
            ) {
                when (viewState.selectedTabIndex) {
                    0 -> ProfileVideosView()
                    1 -> ProfilePlaylistsView()
                    2 -> ProfileAboutView()
                }
            }
        }
    }
}

@Composable
@Preview
private fun ProfileViewPreview() {
    AppTheme {
        ProfileView(
            viewState = ProfileViewState(
                name = "Natalie",
                subscribers = "5.3m subscribers",
                joinedIn = "Joined in 2017",
                isSubscribed = true
            )
        ) {

        }
    }
}