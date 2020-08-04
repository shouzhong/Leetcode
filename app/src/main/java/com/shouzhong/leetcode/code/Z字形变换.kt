package com.shouzhong.leetcode.code

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 如s = "abcdefghijklmn", numRows = 4, 输出为"agmbfhlnceikdj"
 * a     g     m
 * b   f h   l n
 * c e   i k
 * d     j
 */
fun convert(s: String?, numRows: Int): String? {
    val len = s?.length ?: 0
    if (len <= numRows || numRows == 1) return s
    val sb = StringBuffer()
    val m = (numRows - 1) * 2
    for (i in 0 until numRows) {
        var n = 0
        while (true) {
            val temp = m * n
            val i1 = temp - i
            val i2 = temp + i
            if (i != 0 && i != numRows - 1) {
                if (i1 in 0 until len) sb.append(s!![i1])
            }
            if (i2 >= len) break
            sb.append(s!![i2])
            n++
        }
    }
    return sb.toString()
}