package study

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class LinkedListTest {
    @Test
    fun study() {
        val list = LinkedList<String>()
        list.add("first")
        list.add("second")

        assertEquals(2, list.size.toLong()) // list의 크기를 구하라.
        assertEquals("first", list[0]) // 첫 번째 값을 찾아라.
        assertEquals(true, list.contains("first")) // "first" 값이 포함되어 있는지를 확인해라.
        assertEquals("first", list.removeAt(0)) // 첫 번째 값을 삭제해라.
        assertEquals(false, list.contains("first")) // "first" 값이 포함되어 있는지를 확인해라.
    }
}