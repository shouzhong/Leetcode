package com.shouzhong.leetcode.code

import com.shouzhong.leetcode.code.ListNode

/**
 * 两两交换链表中的节点
 *
 */
fun swapPairs(head: ListNode?): ListNode? {
    var head = head
    if (head?.next == null) {
        return head
    }
    val temp1: ListNode = head
    val temp2 = head.next
    val temp3 = swapPairs(head.next.next)
    head = temp2
    head.next = temp1
    head.next.next = temp3
    return head
}