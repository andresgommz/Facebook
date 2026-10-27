package me.andresgomez.facebook.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PostAction(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        LikeButton(isLiked = isLiked)
        CommentButton()
        ShareButton()
    }
}

@Preview(showBackground = true)
@Composable
fun PostActionPreview() {
    PostAction()
}
