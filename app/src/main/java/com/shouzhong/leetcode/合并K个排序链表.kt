package com.shouzhong.leetcode

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 */
fun mergeKLists(lists: Array<ListNode?>?): ListNode? {
    val len = lists?.size ?: 0
    if (len == 0) return null
    return if (len == 1) lists!![0] else mergeKLists(lists, 0, len - 1)
}

fun mergeKLists(lists: Array<ListNode?>?, start: Int, end: Int): ListNode? {
    if (start == end) {
        return lists!![start]
    }
    val mid = start + (end - start) / 2
    val l1 = mergeKLists(lists, start, mid)
    val l2 = mergeKLists(lists, mid + 1, end)
    return mergeKLists(l1, l2)
}

fun mergeKLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1
    if (l1.`val` < l2.`val`) {
        l1.next = mergeKLists(l1.next, l2)
        return l1
    }
    l2.next = mergeKLists(l1, l2.next)
    return l2
}