package leetcode.sumofnumber

import java.lang.ref.SoftReference

fun main(args: Array<String>) {

    val solution = Solution()

    val l1 = ListNode(4)
    val tempL1 = SoftReference<ListNode>(l1)
    l1.next = ListNode(5)
    l1.next?.next = ListNode(4)
    val l2 = ListNode(8)
    val tempL2 = SoftReference<ListNode>(l2)
    l2.next = ListNode(7)
    l2.next?.next = ListNode(8)
    l2.next?.next?.next = ListNode(5)
    l2.next?.next?.next?.next = ListNode(8)

    var l3 = solution.addTwoNumbers(tempL1.get(), tempL2.get())
    while (l3 != null) {
        print("${l3.number} -> ")
        l3 = l3.next
    }
    println("NULL")

}