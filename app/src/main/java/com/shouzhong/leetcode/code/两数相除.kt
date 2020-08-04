package com.shouzhong.leetcode.code

import kotlin.math.abs

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 */
fun divide(dividend: Int, divisor: Int): Int {
    var dividend = dividend
    var divisor = divisor
    if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE
    val k = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0
    var result = 0
    dividend = -abs(dividend)
    divisor = -abs(divisor)
    while (dividend <= divisor) {
        var temp = divisor
        var c = 1
        while (dividend - temp <= temp) {
            temp = temp shl 1
            c = c shl 1
        }
        dividend -= temp
        result += c
    }
    return if (k) result else -result
}