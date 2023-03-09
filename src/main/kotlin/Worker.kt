import java.util.concurrent.atomic.AtomicInteger

public class Worker(
    private val firstName: String,
    private val lastName: String,
    private var age: Int,
    private var post: String
) {

    companion object {
        private val count: AtomicInteger = AtomicInteger(0)
    }

    private val id = count.incrementAndGet()

    public fun getFirstName(): String {
        return firstName
    }

    public fun getLastName(): String {
        return lastName
    }

    public fun getId(): Int {
        return id
    }

    public fun getPost(): String {
        return post
    }

    public fun setAge(age: Int) {
        if (this.age != age) {
            this.age = age
        } else {
            println("Указанный возраст уже установлен")
        }
    }

    public fun setPost(post: String){
        if (this.post != post) {
            this.post = post
        } else {
            println("Указанная должность уже установлена")
        }
    }

    override fun toString(): String {
        return "$firstName $lastName, возраст: $age, должность: $post, id: $id"
    }
}