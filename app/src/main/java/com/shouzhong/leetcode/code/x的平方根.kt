package com.shouzhong.leetcode.code

import kotlin.math.abs

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 二分法
 */
fun mySqrt(x: Int): Int {
    var min = 0
    var max = x
    var result = -1
    while (min <= max) {
        val mid = min + (max - min) / 2
        val temp = mid * mid.toLong()
        if (temp == x.toLong()) return mid
        if (temp < x) {
            result = mid
            min = mid + 1
        } else max = mid - 1
    }
    return result
}

/**
 * 牛顿迭代法
 *
 */
fun mySqrt2(x: Int): Int {
    if (x == 0) return 0
    val c = x.toDouble()
    var x0 = c
    while (true) {
        val xi = 0.5 * (x0 + c / x0)
        if (abs(xi - x0) < 1e-7) break
        x0 = xi
    }
    return x0.toInt()
}