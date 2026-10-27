package me.andresgomez.facebook.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.andresgomez.facebook.Post
import me.andresgomez.facebook.ui.components.PostCard
import me.andresgomez.facebook.ui.components.StoriesRow

val samplePosts = listOf(
    Post(
        id = 1,
        author = "Andrés Gómez",
        time = "Hace 2 h",
        content = "¡Por fin terminé la pantalla de login en Compose! 🚀💻",
        likes = 24,
        comments = 5,
        liked = true,
        imageUrl = "https://picsum.photos/seed/post1/600/400"
    ),
    Post(
        id = 2,
        author = "María Rodríguez",
        time = "Hace 4 h",
        content = "Un día increíble en las montañas 🏔️🌲 Disfrutando del fin de semana.",
        likes = 152,
        comments = 18,
        liked = false,
        imageUrl = "https://picsum.photos/seed/post2/600/400"
    ),
    Post(
        id = 3,
        author = "Carlos Mendoza",
        time = "Hace 6 h",
        content = "¿Alguien recomienda buenos cursos de Jetpack Compose y Kotlin Multiplatform? 🤔",
        likes = 12,
        comments = 9,
        liked = false,
        imageUrl = null
    ),
    Post(
        id = 4,
        author = "Laura Sánchez",
        time = "Ayer a las 18:30",
        content = "Receta de café helado casero ☕🧊 Perfecto para refrescar el día.",
        likes = 89,
        comments = 14,
        liked = true,
        imageUrl = "https://picsum.photos/seed/post4/600/400"
    )
)

@Composable
fun FeedScreen(
    posts: List<Post> = samplePosts
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        // Sección de Historias
        item {
            StoriesRow()
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Lista de publicaciones
        items(posts, key = { it.id }) { post ->
            PostCard(post = post)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun FeedScreenPreview() {
    FeedScreen()
}
