package com.shouzhong.leetcode

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 */
fun removeNthFromEnd(
    head: ListNode?,
    n: Int
): ListNode? {
    val node: ListNode = ListNode(0)
    node.next = head
    var first: ListNode? = node
    var second: ListNode? = node
    for (i in 0 until n + 1) {
        first = first!!.next
        if (first == null && i < n) return node.next
    }
    while (first != null) {
        first = first.next
        second = second!!.next
    }
    second!!.next = second.next?.next
    return node.next
}