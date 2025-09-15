package org.kzerkovich.pulse

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.net.toUri
import org.kzerkovich.pulse.core.database.AppDatabase
import org.kzerkovich.pulse.core.database.getDataBaseBuilder
import org.kzerkovich.pulse.core.database.getRoomDatabase
import org.kzerkovich.pulse.core.di.InjectProvider

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val appDatabase = getRoomDatabase(
            getDataBaseBuilder(applicationContext)
        )

        InjectProvider.addDependency("database", appDatabase)

        setContent { App() }
    }
}

internal actual fun openUrl(url: String?) {
    val uri = url?.toUri() ?: return
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = uri
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    AndroidApp.INSTANCE.startActivity(intent)
}
