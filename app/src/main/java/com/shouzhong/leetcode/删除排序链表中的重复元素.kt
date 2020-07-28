package com.shouzhong.leetcode

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 */
fun deleteDuplicates(head: ListNode?): ListNode? {
    var temp = head
    while (temp?.next != null) {
        if (temp.next.`val` == temp.`val`) {
            temp.next = temp.next.next
        } else {
            temp = temp.next
        }
    }
    return head
}