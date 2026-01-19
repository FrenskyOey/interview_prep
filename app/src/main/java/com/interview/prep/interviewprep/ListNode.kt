package com.interview.prep.interviewprep

class ListNode<T> (
    var value: T,
    var next: ListNode<T>? = null
) {
    // Optional: Custom toString to prevent stack overflow on long lists
    // and to print it in a readable "1 -> 2 -> null" format.
    override fun toString(): String {
        return "$value -> ${next?.toString() ?: "null"}"
    }

    fun connectNextNode(input : ListNode<T>){
        next = input
    }

}

fun IntArray.toListNode(): ListNode<Int>? {
    if (this.isEmpty()) return null

    val head = ListNode(this[0])
    var current = head

    for (i in 1 until this.size) {
        current.next = ListNode(this[i])
        current = current.next!!
    }
    return head
}