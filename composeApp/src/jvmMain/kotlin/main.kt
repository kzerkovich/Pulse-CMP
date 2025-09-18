import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.kzerkovich.pulse.App
import org.kzerkovich.pulse.core.database.getDataBaseBuilder
import org.kzerkovich.pulse.core.database.getRoomDatabase
import org.kzerkovich.pulse.core.di.InjectProvider
import java.awt.Dimension

fun main() = application {
    Window(
        title = "Pulse",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)

        val appDatabase = getRoomDatabase(
            getDataBaseBuilder()
        )

        InjectProvider.addDependency("database", appDatabase)

        App()
    }
}

