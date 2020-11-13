package leetcode.linkedlist

fun main(args: Array<String>) {

    val solution = Solution()
    val l1n1 = LinkedListNode(3)
    val l1n2 = LinkedListNode(4)
    val l1n3 = LinkedListNode(2)
    val l1n4 = LinkedListNode(1)
    val l1n5 = LinkedListNode(5)
    val l1n6 = LinkedListNode(7)
    l1n1.next = l1n2
    l1n2.next = l1n3
    l1n3.next = l1n4
    l1n4.next = l1n5
    l1n5.next = l1n6
    var l = solution.oddEvenList(l1n1)
    while (l != null) {
        print("${l.num} -> ")
        l = l.next
    }
    print("NULL")

}