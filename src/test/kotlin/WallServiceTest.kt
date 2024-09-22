import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class WallServiceTest {

    private lateinit var service: WallService

    @Before
    fun setUp() {
        service = WallService
    }

    @Test
    fun addPostIdNotZero() {
        val post = Post(
            authorId = 1,
            content = "Hello, world!",
            created = System.currentTimeMillis()
        )
        val addedPost = service.add(post)
        assertTrue(addedPost.id != 0L)
    }

    @Test
    fun updateExistingPostReturnsTrue() {
        val post = Post(
            authorId = 1,
            content = "Hello, world!",
            created = System.currentTimeMillis()
        )
        val addedPost = service.add(post)
        val updatedPost = addedPost.copy(content = "Updated content")
        val result = service.update(updatedPost)
        assertTrue(result)
    }

    @Test
    fun updateNonExistingPostReturnsFalse() {
        val post = Post(
            id = 1,
            authorId = 1,
            content = "Hello, world!",
            created = System.currentTimeMillis()
        )
        val result = service.update(post)
        assertTrue(!result)
    }

    @Test
    fun clearPosts() {
        val post = Post(
            authorId = 1,
            content = "Hello, world!",
            created = System.currentTimeMillis()
        )
        service.add(post)
        service.clear()
        assertTrue(service.getPosts().isEmpty())
    }
}