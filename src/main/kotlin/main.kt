
fun main() {
    println("Hello, World!")
}

data class Post(
    val id: Long = 0,
    val authorId: Long = 0,
    val content: String = "",
    val created: Long = 0,
    val likes: Int = 0,
    val comments: Int = 0,
    val shares: Int = 0,
    val address: String? = null,
    val location: Pair<Double, Double>? = null
)

object WallService {
    private var nextId = 1L
    private val posts = mutableListOf<Post>()

    fun add(post: Post): Post {
        val postWithId = post.copy(id = nextId)
        posts.add(postWithId)
        nextId++
        return postWithId
    }

    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { it.id == post.id }
        return if (index != -1) {
            posts[index] = post
            true
        } else {
            false
        }
    }

    fun clear() {
        posts.clear()
        nextId = 1L
    }

    fun getPosts(): List<Post> {
        return posts
    }
}


