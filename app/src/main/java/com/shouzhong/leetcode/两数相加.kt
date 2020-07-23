package com.shouzhong.leetcode

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    return addTwoNumbers(l1, l2, 0)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?, i: Int): ListNode? {
    if (l1 == null && l2 == null) {
        return if (i != 0) ListNode(i) else null
    }
    var sum = i
    if (l1 != null) sum += l1.`val`
    if (l2 != null) sum += l2.`val`
    val ln = ListNode(sum % 10)
    ln.next = addTwoNumbers(
        l1?.next,
        l2?.next,
        sum / 10
    )
    return ln
}