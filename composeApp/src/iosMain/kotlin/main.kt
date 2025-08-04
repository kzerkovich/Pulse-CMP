import androidx.compose.ui.window.ComposeUIViewController
import kzerk.pulse.demo.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
