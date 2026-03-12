package com.practice.leet

// Most awesome solution
/*
* Step-by-Step Walkthrough
# Initialization: Pointers ptrA and ptrB start at the heads of their respective lists.

# The Loop (while (ptrA != ptrB)): The loop continues as long as the pointers are at different nodes.

# The Traversal & Swap: * If ptrA has not reached the end, it moves to the next node (ptrA.next).

    If ptrA hits the end (null), it instantly teleports to the start of the other list (headB).

    ptrB does the exact same thing, but swaps to headA when it finishes.

# The Meeting Point: Eventually, one of two things happens:

    They intersect: Both pointers land on the intersection node at the exact same time. The loop breaks, and it returns that node.

No intersection: If the lists never merge, both pointers will travel the full length of both lists and hit null at the exact same time.
* The loop breaks (null == null), and it safely returns null.

Complexity
* Time Complexity: $O(M + N), where $M$ and $N$ are the lengths of the two lists.
* In the worst case, each pointer travels both lists exactly once.
* Space Complexity: $O(1) constant space. You are only using two pointers, regardless of how massive the lists are.
*
* */
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var ptrA = headA
    var ptrB = headB
    // Traverse through list A with 'ptrA' and list B with 'ptrB'
    // until they meet.
    while (ptrA != ptrB) {
        // Traverse list A -> list B by first traversing 'ptrA' and
        // then, upon reaching the end of list A, continue the
        // traversal from the head of list B.
        ptrA = if (ptrA != null) ptrA.next else headB
        // Simultaneously, traverse list B -> list A.
        ptrB = if (ptrB != null) ptrB.next else headA
    }
    // At this point, 'ptrA' and 'ptrB' either point to the
    // intersection node or both are null if the lists do not
    // intersect. Return either pointer.
    return ptrA
}

fun getIntersectionNode3(headA:ListNode?, headB:ListNode?):ListNode? {
    val listA = mutableListOf<ListNode>()
    val listB = mutableListOf<ListNode>()
    var tempA = headA
    var tempB = headB

    while (tempA != null) {
        listA.add(tempA)
        tempA = tempA.next
    }
    while (tempB != null) {
        listB.add(tempB)
        tempB = tempB.next
    }
    if(tempB != tempA) {
        return null
    }

    var indexA = listA.lastIndex
    var indexB = listB.lastIndex
    while (listA[indexA] == listB[indexB]) {
        if(indexA == 0) {
            return listA[indexA]
        }
        if(indexB == 0) {
            return listB[indexB]
        }

        indexA += -1
        indexB += -1
        if(listA[indexA] != listB[indexB]) {
            return listA[indexA+1]
        }
    }

    return null
}

fun getIntersectionNode2(headA:ListNode?, headB:ListNode?):ListNode? {
    var tempA = headA
    var tempB = headB
    if(tempA == tempB) {
        return tempA
    }
    while (tempA != null) {
        while (tempB != null) {
            if(tempB == tempA) {
                return tempB
            }
            tempB = tempB.next
        }
        tempB = headB
        tempA = tempA.next
    }
    println(tempB == tempA)

    return null
}

fun main() {
    val a1 = ListNode(4)
    val a2 = ListNode(1)
    val b1 = ListNode(5)
    val b2 = ListNode(6)
    val b3 = ListNode(1)
    val c1 = ListNode(8)
    val c2 = ListNode(4)

    a1.next = a2
    a2.next = c1
    b1.next = b2
    b2.next = b3

    a2.next = c1
    b3.next = c1
    c1.next = c2

    val node = getIntersectionNode(a1, b1)
    println(node?.`val`)
}