package com.shouzhong.leetcode.code

fun countBinarySubstrings(s: String): Int {
    val len = s.length
    var index = -1
    var num0 = 0
    var num1 = 0
    var result = 0
    for (i in 0 until len) {
        val c = s[i]
        if (c == '0') {
            if (index != 0) {
                result += Math.min(num0, num1)
                num0 = 0
            }
            num0++
            index = 0
        } else if (c == '1') {
            if (index != 1) {
                result += Math.min(num0, num1)
                num1 = 0
            }
            num1++
            index = 1
        }
    }
    result += Math.min(num0, num1)
    return result
}