package com.shouzhong.leetcode

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 */
fun myPow(x: Double, n: Int): Double {
    var n = n
    if (x == 0.0) return 0.0
    if (x == 1.0 || n == 0) return 1.0
    if (n == Int.MIN_VALUE) return 1 / myPow(x, Int.MAX_VALUE) / x
    if (n < 0) return 1 / myPow(x, -n)
    var result = 1.0
    var temp = x
    while (n > 0) {
        if (n % 2 == 1) result *= temp
        temp *= temp
        n /= 2
    }
    return result
}