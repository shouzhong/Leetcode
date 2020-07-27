package com.shouzhong.leetcode

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 */
fun multiply(num1: String, num2: String): String? {
    if (num1 == "0" || num2 == "0") return "0"
    val len1 = num1.length
    val len2 = num2.length
    val res = IntArray(len1 + len2)
    for (i in len1 - 1 downTo 0) {
        val n1 = num1[i] - '0'
        for (j in len2 - 1 downTo 0) {
            val n2 = num2[j] - '0'
            val sum = res[i + j + 1] + n1 * n2
            res[i + j + 1] = sum % 10
            res[i + j] += sum / 10
        }
    }
    val len = len1 + len2
    val sb = StringBuffer()
    for (i in 0 until len) {
        if (i == 0 && res[i] == 0) continue
        sb.append(res[i])
    }
    return sb.toString()
}