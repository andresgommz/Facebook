package me.andresgomez.facebook.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.andresgomez.facebook.Post

@Composable
fun PostCard(
    post: Post,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        PostHeader(
            userName = post.author,
            timeAgo = post.time,
        )

        Text(
            text = post.content,
            modifier = Modifier.padding(horizontal = 12.dp),
        )

        post.imageUrl?.let { url ->
            if (url.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))

                AsyncImage(
                    model = url,
                    contentDescription = "Imagen de la publicación",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop,
                )
            }
        }

        PostAction(
            isLiked = post.liked,
        )

        PostStats(
            likes = post.likes,
            comments = post.comments,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    PostCard(
        post = Post(
            id = 1,
            author = "Andrés Gómez",
            time = "Hace 2 h",
            content = "¡Por fin terminé la pantalla de login en compose!",
            likes = 24,
            comments = 3,
            liked = true,
            imageUrl = "https://picsum.photos/600/400"
        )
    )
}
