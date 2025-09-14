package dev.convex.officialquickstart

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.convex.android.ConvexClient

@Composable
fun Tasks(client: ConvexClient, modifier: Modifier = Modifier) {
    var tasks: List<Task> by remember { mutableStateOf(listOf()) }
    LaunchedEffect(key1 = "launch") {
        client.subscribe<List<Task>>("tasks:get").collect { result ->
            result.onSuccess { remoteTasks ->
                tasks = remoteTasks
            }
        }
    }
    LazyColumn(
        modifier = modifier
    ) {
        item { Text(text = "Convex") }
        items(tasks) { task ->
            Text(text = "Text: ${task.text}, Completed?: ${task.isCompleted}")
        }
    }
}