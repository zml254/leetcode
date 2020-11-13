package leetcode.sumofnumber

import java.lang.ref.SoftReference

class Solution {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var flag = 0
        if (l1 == null && l2 == null) {
            return ListNode(-1)
        } else if (l1 == null) {
            return l2
        } else if (l2 == null) {
            return l1
        }
        var l3: ListNode?
        if (l1.number + l2.number >= 10) {
            l3 = ListNode(l1.number + l2.number - 10)
            flag = 1
        } else {
            l3 = ListNode(l1.number + l2.number)
        }
        val temp = SoftReference<ListNode>(l3)
        var list1 = l1.next
        var list2 = l2.next
        while (true) {
            if (list1 == null) {
                if (list2 == null) {
                    l3?.next = null
                    return temp.get()
                }
                l3?.next = ListNode((list2.number) + flag)
                l3?.next?.next = list2.next
                return temp.get()
            }
            if (list2 == null) {
                l3?.next = ListNode(list1.number + flag)
                l3?.next?.next = list1.next
                return temp.get()
            }
            if (list1.number + list2.number >= 10) {
                l3?.next = ListNode(list1.number + list2.number - 10 + flag)
                l3 = l3?.next
                flag = 1
            } else {
                l3?.next = ListNode(list1.number + list2.number + flag)
                l3 = l3?.next
                flag = 0
            }
            list1 = list1.next
            list2 = list2.next
        }
    }

}