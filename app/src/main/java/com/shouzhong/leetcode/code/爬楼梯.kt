package com.shouzhong.leetcode.code

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 */
fun climbStairs(n: Int): Int {
    var p = 0
    var q = 0
    var r = 1
    for (i in 0 until n) {
        p = q
        q = r
        r = p + q
    }
    return r
}

fun climbStairs2(n: Int): Int {
    val d = Math.sqrt(5.0)
    return Math.round(
        1 / d * (Math.pow(
            (1 + d) / 2,
            n + 1.toDouble()
        ) - Math.pow((1 - d) / 2, n + 1.toDouble()))
    ).toInt()
}

fun climbStairs3(n: Int): Int {
    if (n == 1) return 1
    return if (n == 2) 2 else climbStairs3(n - 1) + climbStairs(n - 2)
}