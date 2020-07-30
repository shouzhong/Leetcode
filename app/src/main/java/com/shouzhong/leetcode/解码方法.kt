package com.shouzhong.leetcode

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：'A'->1,...,'Z'->26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 */
fun numDecodings(s: String): Int {
    val len = s.length
    if (len == 0 || s[0] == '0') return 0
    // i - 2位置有几个
    var last2 = 1
    // i - 1位置有几个
    var last1 = 1
    for (i in 1 until len) {
        val temp = last1
        val cCurrent = s[i]
        val cLast = s[i - 1]
        if (cCurrent == '0') {
            if (cLast != '1' && cLast != '2') return 0
            last1 = last2
        } else if (cLast == '1' || cLast == '2' && cCurrent >= '1' && cCurrent <= '6') {
            last1 += last2
        }
        last2 = temp
    }
    return last1
}