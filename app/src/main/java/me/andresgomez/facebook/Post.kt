package me.andresgomez.facebook

data class Post(
    val id: Int,
    val author: String,
    val time: String,
    val content: String,
    val likes: Int,
    val comments: Int,
    val liked: Boolean = false,
)
