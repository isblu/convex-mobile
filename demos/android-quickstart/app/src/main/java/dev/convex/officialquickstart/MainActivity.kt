package dev.convex.officialquickstart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dev.convex.android.ConvexClient
import dev.convex.officialquickstart.ui.theme.OfficialQuickstartTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OfficialQuickstartTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Tasks(
                        client = ConvexClient("https://colorless-seahorse-122.convex.cloud"),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Serializable
data class Task(val text: String, val isCompleted: Boolean)