package com.shouzhong.leetcode.code

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 另一种更高效率的方法是截取一定长度字符串转为long再计算，比如长度取62
 *
 */
fun addBinary(a: String, b: String): String? {
    val len1 = a.length
    val len2 = b.length
    val len = Math.max(len1, len2)
    var temp = 0
    val sb = StringBuilder()
    for (i in 0 until len) {
        val i1 = if (len1 - i - 1 >= 0) a[len1 - i - 1] - '0' else 0
        val i2 = if (len2 - i - 1 >= 0) b[len2 - i - 1] - '0' else 0
        val sum = i1 + i2 + temp
        sb.insert(0, sum and 1)
        temp = sum shr 1
    }
    if (temp != 0) sb.insert(0, temp)
    return sb.toString()
}