import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import org.kzerkovich.pulse.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() = ComposeViewport { App() }
