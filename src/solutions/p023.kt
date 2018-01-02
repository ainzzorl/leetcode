package solutions;

import util.ListNode
import java.util.*

// https://leetcode.com/problems/merge-k-sorted-lists/description/
class p023 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val queue = PriorityQueue<ListPointer>()
        var head: ListNode? = null
        var tail: ListNode? = null
        for (list in lists) {
            if (list != null) {
                queue.add(ListPointer(list))
            }
        }
        while (!queue.isEmpty()) {
            val current = queue.poll().list
            if (tail == null) {
                tail = ListNode(current.`val`)
                head = tail
            } else {
                tail.next = ListNode(current.`val`)
                tail = tail.next
            }
            val next = current.next
            if (next != null) {
                queue.offer(ListPointer(next))
            }
        }
        return head
    }

    class ListPointer(var list: ListNode) : Comparable<ListPointer> {
        override fun compareTo(other: ListPointer): Int {
            return list.`val` - other.list.`val`
        }
    }
}
