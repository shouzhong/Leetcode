package com.shouzhong.leetcode

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 */
fun intToRoman(num: Int): String {
    var num = num
    if (num <= 0 || num >= 4000) return ""
    val sb = StringBuffer()
    var count = num / 1000
    if (count > 0) {
        for (i in 0 until count) {
            sb.append('M')
        }
        return sb.toString() + intToRoman(num % 1000)
    }
    if (num / 900 > 0) {
        num %= 900
        sb.append("CM")
    } else if (num / 500 > 0) {
        num %= 500
        sb.append("D")
        count = num / 100
        if (count > 0) {
            num %= 100
            for (i in 0 until count) {
                sb.append('C')
            }
        }
    } else if (num / 400 > 0) {
        num %= 400
        sb.append("CD")
    } else {
        count = num / 100
        if (count > 0) {
            num %= 100
            for (i in 0 until count) {
                sb.append('C')
            }
        }
    }
    if (num / 90 > 0) {
        num %= 90
        sb.append("XC")
    } else if (num / 50 > 0) {
        num %= 50
        sb.append('L')
        count = num / 10
        if (count > 0) {
            num %= 10
            for (i in 0 until count) {
                sb.append('X')
            }
        }
    } else if (num / 40 > 0) {
        num %= 40
        sb.append("XL")
    } else {
        count = num / 10
        if (count > 0) {
            num %= 10
            for (i in 0 until count) {
                sb.append('X')
            }
        }
    }
    if (num / 9 > 0) {
        sb.append("IX")
    } else if (num / 5 > 0) {
        num %= 5
        sb.append('V')
        count = num
        if (count > 0) {
            for (i in 0 until count) {
                sb.append('I')
            }
        }
    } else if (num / 4 > 0) {
        sb.append("IV")
    } else {
        count = num
        if (count > 0) {
            for (i in 0 until count) {
                sb.append('I')
            }
        }
    }
    return sb.toString()
}