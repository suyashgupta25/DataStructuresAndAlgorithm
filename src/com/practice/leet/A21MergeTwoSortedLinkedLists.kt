package com.practice.leet

import java.util.PriorityQueue

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if(list1 == null) return list2
    if(list2 == null) return list1

    return if(list1.`val` > list2.`val`) {
        list2.next = mergeTwoLists(list1, list2.next)
        list2
    } else {
        list1.next = mergeTwoLists(list1.next, list2)
        list1
    }
}

fun mergeTwoListsWithHeap(list1: ListNode?, list2: ListNode?): ListNode? {
    val heap = PriorityQueue<ListNode> { a, b -> a.`val`.compareTo(b.`val`) }

    if (list1 != null) heap.offer(list1)
    if (list2 != null) heap.offer(list2)

    val dummy = ListNode(0)
    var current = dummy

    while (heap.isNotEmpty()) {
        val node = heap.poll()
        current.next = node
        current = current.next!!

        if (node.next != null) {
            heap.offer(node.next!!)
        }
    }

    return dummy.next
}


fun main() {
    val l1 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(4) } }
    val l2 = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }

    var result = mergeTwoListsWithHeap(l1, l2)
    while (result != null) {
        print("${result.`val`} ")
        result = result.next
    }
}
