package com.shouzhong.leetcode

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 *
 */
fun longestPalindrome(s: String?): String? {
    val len = s?.length ?: 0
    if (len < 2) return s
    val sb = StringBuffer()
    for (i in 0 until len) {
        sb.append('#').append(s!![i])
    }
    val str = sb.append('#').toString()
    val newLen = str.length
    val p = IntArray(newLen)
    var maxRight = 0
    var center = 0
    var start = 0
    var maxLen = 1
    for (i in 0 until newLen) {
        if (i < maxRight) {
            p[i] = (maxRight - i).coerceAtMost(p[2 * center - i])
        }
        var left = i - (p[i] + 1)
        var right = i + (p[i] + 1)
        while (left >= 0 && right < newLen && str[left] == str[right]) {
            left--
            right++
            p[i]++
        }
        if (i + p[i] > maxRight) {
            center = i
            maxRight = center + p[i]
        }
        if (p[i] > maxLen) {
            maxLen = p[i]
            start = (i - maxLen) / 2
        }
    }
    return s!!.substring(start, start + maxLen)
}