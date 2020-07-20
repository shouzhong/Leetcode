package com.shouzhong.leetcode

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
fun reverse(x: Int): Int {
    var x = x
    var result = 0
    while (x != 0) {
        val temp = x % 10
        x /= 10
        if (result > 214748364 || result == 214748364 && temp > 7) return 0
        if (result < -214748364 || result == -214748364 && temp < -8) return 0
        result = result * 10 + temp
    }
    return result
}