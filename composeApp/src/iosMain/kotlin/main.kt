import androidx.compose.ui.window.ComposeUIViewController
import org.kzerkovich.pulse.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
