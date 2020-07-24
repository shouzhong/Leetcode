package com.shouzhong.leetcode

/**
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * 注意：整数序列中的每一项将表示为一个字符串。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 *
 */
fun countAndSay(n: Int): String {
    if (n < 1) return ""
    if (n == 1) return "1"
    val s = countAndSay(n - 1)
    val sb = StringBuffer()
    val len = s.length
    var c = s[0]
    var count = 1
    for (i in 1 until len) {
        val temp = s[i]
        if (temp == c) count++ else {
            sb.append(count).append(c)
            c = temp
            count = 1
        }
    }
    sb.append(count).append(c)
    return sb.toString()
}