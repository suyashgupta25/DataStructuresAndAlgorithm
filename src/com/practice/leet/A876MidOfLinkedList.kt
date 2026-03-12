package com.practice.leet



fun middleNode(head: ListNode?): ListNode? {
    if (head == null || head.next == null) return head

    var slowPointer:ListNode? = head
    var fastPointer:ListNode? = head

    while (fastPointer?.next != null) {
//        println("f="+fastPointer.`val`)
//        println("s="+slowPointer?.`val`)
        slowPointer = slowPointer?.next
        fastPointer = fastPointer.next?.next
    }
    return slowPointer
}

fun main() {
    val m4 = ListNode(4)
    val m3 = ListNode(3)
    val m2 = ListNode(2)
    val m1 = ListNode(1)
    m1.next = m2
    m2.next = m3
    m3.next = m4
    println("fi="+middleNode(m1)?.`val`)
}