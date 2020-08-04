package com.shouzhong.leetcode.code

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
fun plusOne(digits: IntArray): IntArray? {
    val len = digits.size
    var temp = 1
    for (i in len - 1 downTo 0) {
        if (temp == 0) break
        val sum = digits[i] + temp
        digits[i] = sum % 10
        temp = sum / 10
    }
    if (temp == 0) return digits
    val result = IntArray(len + 1)
    result[0] = temp
    return result
}