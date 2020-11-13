package leetcode.softreference

import java.lang.ref.SoftReference

fun main(args: Array<String>) {

    var l1 = ListNode(1)
    val tempL1 = SoftReference<ListNode>(l1)
    l1.next = ListNode(2)
    l1 = l1.next!!
    println(l1.num)
    println(tempL1.get()?.num)
    l1 = tempL1.get() ?: ListNode(-1)
    println(l1.num)
    println(l1.next?.num)

}