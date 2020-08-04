package com.shouzhong.leetcode.code

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 */
fun integerBreak(n: Int): Int {
    if (n <= 3) return n - 1
    val p = n / 3
    val q = n % 3
    return if (q == 0) Math.pow(
        3.0,
        p.toDouble()
    ).toInt() else if (q == 1) (Math.pow(
        3.0,
        p - 1.toDouble()
    ) * 4).toInt() else (Math.pow(3.0, p.toDouble()) * 2).toInt()
}