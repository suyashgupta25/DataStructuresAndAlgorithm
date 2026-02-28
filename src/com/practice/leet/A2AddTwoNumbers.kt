package com.practice.leet

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummyHead = ListNode(0) // Dummy node to easily build the result list
    var curr = dummyHead

    var p = l1
    var q = l2
    var carry = 0

    // Loop through lists until both are exhausted
    while (p != null || q != null) {
        // Get the values from the current nodes (use 0 if a list is exhausted)
        val x = p?.`val` ?: 0
        val y = q?.`val` ?: 0

        // Calculate sum and update carry
        val sum = carry + x + y
        carry = sum / 10

        // Create a new node with the digit part of the sum
        curr.next = ListNode(sum % 10)
        curr = curr.next!! // Move the current pointer forward

        // Advance the pointers for l1 and l2
        if (p != null) p = p.next
        if (q != null) q = q.next
    }

    // Check if there's a leftover carry after the final addition
    if (carry > 0) {
        curr.next = ListNode(carry)
    }

    // Return the actual head of the resulting list
    return dummyHead.next
}

fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
    println(createNumber(l1))
    println(createNumber(l2))
    val sum = createNumber(l1) + createNumber(l2)
    println(sum)
    val c = createNode(sum, null)
//    println("num="+createNumber(listNode2))
    return c
}
var listNode2:ListNode? = null

fun createNode(num: Int, node: ListNode?): ListNode?  {
    val quotient = num / 10 // 342 -> 34 -> 3 -> 0
    val remainder = num % 10 // 342 -> 2 -> 4 -> 3
    println("quotient=$quotient, remainder=$remainder")
    val listNode = ListNode(remainder)
    if(quotient == 0) {
        node?.next = listNode
        return listNode
    }
    if(node == null) {
        if(listNode2 == null)
            listNode2 = listNode
        listNode.next = createNode(quotient, listNode)
    } else {
        node.next = listNode
        createNode(quotient, node.next)
    }

    return listNode
}

fun createNumber(node: ListNode?): Int {
    node?.`val` ?: return 0
    return node.`val` + createNumber(node.next) * 10
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
//    val n3 = ListNode(3)
//    val n2 = ListNode(4)
    val n1 = ListNode(9)
//    n1.next = n2
//    n2.next = n3

    val m3 = ListNode(1)
    val m2 = ListNode(9)
    val m1 = ListNode(9)
    m1.next = m2
    m2.next = m3
    addTwoNumbers(n1, m1)
}