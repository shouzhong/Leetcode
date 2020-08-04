package com.shouzhong.leetcode.code

/**
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * 提示：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 */
fun myAtoi(str: String?): Int {
    val len = str?.length ?: 0
    if (len == 0) return 0
    var result = 0
    var n = 1
    var b1 = false
    var b2 = false
    for (i in 0 until len) {
        val c = str!![i]
        if (c == ' ') {
            if (b1) break
            continue
        }
        b1 = true
        if (c == '-' || c == '+') {
            if (b2) break
            b2 = true
            n = if (c == '-') -1 else 1
            continue
        }
        if (c in '0'..'9') {
            b2 = true
            val num = c - '0'
            if (result > Int.MAX_VALUE / 10) return if (n == 1) Int.MAX_VALUE else Int.MIN_VALUE
            if (result == Int.MAX_VALUE / 10) {
                if (n == 1 && num > 7) return Int.MAX_VALUE
                if (n == -1 && num > 8) return Int.MIN_VALUE
            }
            result = result * 10 + (c - '0')
            continue
        }
        break
    }
    return result * n
}