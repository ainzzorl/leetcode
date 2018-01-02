import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import solutions.p023
import util.ListNode

internal class p023_test {
    private var solution: p023 = p023()

    @Test
    fun mergeKLists() {
        assertArrayEquals(
                createLinkedList(1, 2, 3, 4, 5, 6, 7)!!.toArray(),
                solution.mergeKLists(arrayOf(
                        createLinkedList(1, 6),
                        createLinkedList(2, 3, 4),
                        createLinkedList(5, 7)
                ))!!.toArray()
        )
        assertNull(solution.mergeKLists(arrayOf(createLinkedList())))
        assertNull(solution.mergeKLists(arrayOf()))
    }

    private fun createLinkedList(vararg elements: Int): ListNode? {
        if (elements.isEmpty()) {
            return null
        }
        val elementArray = IntArray(elements.size)
        for (i in 0 until elements.size) {
            elementArray[i] = elements[i]
        }
        val result = ListNode(elementArray[0])
        val remaining = elements.drop(1).toIntArray()
        result.next = createLinkedList(*remaining)
        return result
    }
}