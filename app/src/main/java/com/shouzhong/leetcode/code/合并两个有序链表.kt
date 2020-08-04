package com.shouzhong.leetcode.code

import com.shouzhong.leetcode.code.ListNode

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 */
fun mergeTwoLists(
    l1: ListNode?,
    l2: ListNode?
): ListNode? {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.`val` < l2.`val`) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }
    l2.next = mergeTwoLists(l1, l2.next);
    return l2;
//    var l1 = l1
//    var l2 = l2
//    val node = ListNode(0)
//    var temp: ListNode? = node
//    while (l1 != null || l2 != null) {
//        when {
//            l1 == null -> {
//                temp!!.next = l2
//                l2 = l2!!.next
//            }
//            l2 == null -> {
//                temp!!.next = l1
//                l1 = l1.next
//            }
//            l1.`val` < l2.`val` -> {
//                temp!!.next = l1
//                l1 = l1.next
//            }
//            else -> {
//                temp!!.next = l2
//                l2 = l2.next
//            }
//        }
//        temp = temp.next
//    }
//    return node.next
}