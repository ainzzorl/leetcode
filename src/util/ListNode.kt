package util

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null

    fun toArray(): IntArray {
        val result: ArrayList<Int> = ArrayList<Int>()
        var current: ListNode? = this
        while (current != null) {
            result.add(current.`val`)
            current = current.next
        }
        return result.toIntArray()
    }
}
