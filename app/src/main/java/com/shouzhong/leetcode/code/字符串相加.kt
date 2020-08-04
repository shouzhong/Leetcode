package com.shouzhong.leetcode.code

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 */
fun addStrings(num1: String, num2: String): String? {
    val len1 = num1.length
    val len2 = num2.length
    if (len1 == 0) return num2
    if (len2 == 0) return num1
    val len = Math.max(len1, len2)
    var index = 0
    var temp = 0
    val sb = StringBuffer()
    while (index < len) {
        val c1 = if (index < len1) num1[len1 - 1 - index] else '0'
        val c2 = if (index < len2) num2[len2 - 1 - index] else '0'
        val sum = c1.toInt() + c2.toInt() - 2 * '0'.toInt() + temp
        sb.append(sum % 10)
        temp = sum / 10
        index++
    }
    if (temp > 0) sb.append(temp)
    return sb.reverse().toString()
}