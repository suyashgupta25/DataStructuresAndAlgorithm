package com.practice.leet

fun reverseList(head: ListNode?): ListNode? {
    val headNotNull = head ?: return null
    if (headNotNull.next == null) return head

    // new
    var currNode = head
    var prevNode: ListNode? = null
    // Reverse the direction of each node's pointer until 'currNode'
    // is null.
    while (currNode != null) {
        val nextNode = currNode.next
        currNode.next = prevNode
        prevNode = currNode

        // move curr node to next one in the line
        currNode = nextNode
    }
    // 'prevNode' will be pointing at the head of the reversed linked
    // list.
    return prevNode
}

// [1]--->[2]--->[3]--->null
fun reverseLLRecursive(head: ListNode?): ListNode? {
    // 1. The Base Case
    if (head == null || head.next == null) {
        return head
    }

    // 2. The Recursive Step: Reverse everything after the current node
    val newHead = reverseList(head.next)

    // 3. The Pointer Reversal: Make the next node point back to the current node
    head.next?.next = head

    // 4. The Cleanup: Break the original forward connection
    head.next = null

    // Return the new head of the fully reversed list
    return newHead
}

fun main(args: Array<String>) {

}