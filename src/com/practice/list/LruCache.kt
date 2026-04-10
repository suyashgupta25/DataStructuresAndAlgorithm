package com.practice.list

fun main() {
    val cache = LruCache(3)

}

class LruCache(private val capacity: Int) {
    private val hashmap: MutableMap<Int, DoubleLinkedListNode> = mutableMapOf()
    private var head: DoubleLinkedListNode = DoubleLinkedListNode(-1, -1)
    private var tail: DoubleLinkedListNode = DoubleLinkedListNode(-1, -1)

    init {
        this.head.next = this.tail
        this.tail.prev = this.head
    }

    fun get(key: Int): Int {
        if(hashmap.containsKey(key).not()) {
            return -1
        }
        val node = hashmap[key]!!
        removeNode(node)
        addToTail(node)
        hashmap[key] = node
        return node.value
    }

    fun put(key: Int, value: Int) {
        if(key in hashmap) {
            removeNode(hashmap[key]!!)
        }
        val node = DoubleLinkedListNode(key, value)
        hashmap[key] = node

        if(hashmap.size > capacity) {
            hashmap.remove(head.next!!.key)
            removeNode(head.next!!)
        }
        addToTail(node)
    }

    private fun addToTail(node: DoubleLinkedListNode) {
        node.prev = tail.prev
        node.next = tail
        tail.prev?.next = node

        this.tail.prev = node
    }
    // [-1, (1, 57), dd] [dd, (2, 23), qq] [qq, (3, 40), -1]
    private fun removeNode(node: DoubleLinkedListNode) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    data class DoubleLinkedListNode(val key: Int, val value: Int) {
        var prev: DoubleLinkedListNode? = null
        var next: DoubleLinkedListNode? = null
    }
}