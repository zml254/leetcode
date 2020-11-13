package leetcode.linkedlist

import java.lang.ref.SoftReference

class Solution() {

    fun oddEvenList(head: LinkedListNode?): LinkedListNode? {

        if (head?.next == null) {
            return head
        }
        val tempOdd = SoftReference<LinkedListNode>(head)

        val tempEven = SoftReference<LinkedListNode>(head.next)
        var temp = head.next?.next
        var odd = head
        var even = head.next
        odd.next = null
        even?.next = null
        var i = 3
        while (temp != null) {
            if (i % 2 == 0) {
                even?.next = temp
                even = even?.next
                temp = temp.next
                even?.next = null
            } else {
                odd?.next = temp
                odd = odd?.next
                temp = temp.next
                odd?.next = null
            }
            i++
        }
        odd?.next = tempEven.get()
        return tempOdd.get()
    }

}
