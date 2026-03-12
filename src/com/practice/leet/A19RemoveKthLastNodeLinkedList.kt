package com.practice.leet


fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if(head == null) return null
//    printLinkedList(head)
    var temp = head
    var pos = 1
    while (temp?.next != null) {
        temp = temp.next
        pos += 1
    }

    val indexToRemove = pos - n
    temp = head
    pos = 0
    if(indexToRemove == 0) {
        return head.next
    }
    while (pos < indexToRemove-1) {
        temp = temp?.next
        pos += 1
    }
    temp?.next =  temp?.next?.next
//    println(temp?.`val`)
//    println(pos)
//    printLinkedList(head)
    return head
}

fun printLinkedList(head: ListNode) {
    var temp: ListNode? = head
    while(temp != null) {
        println(temp.`val`)
        temp = temp.next
    }
}

fun main() {
    val a1 = ListNode(1)
    val a2 = ListNode(2)
    val a3 = ListNode(3)
    val a4 = ListNode(4)
    val a5 = ListNode(5)

    a1.next = a2
    a2.next = a3
    a3.next = a4
    a4.next = a5

    removeNthFromEnd(a1, 1)
}