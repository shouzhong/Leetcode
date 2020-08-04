package com.shouzhong.leetcode.code

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 */
fun longestCommonPrefix(strs: Array<String>): String? {
    val len = strs.size
    if (len == 0) return ""
    if (len == 1) return strs[0]
    var result = strs[0]
    for (i in 1 until len) {
        result = longestCommonPrefix(result, strs[i])
    }
    return result
}

fun longestCommonPrefix(s1: String, s2: String): String {
    val sb = StringBuffer()
    val len = s1.length.coerceAtMost(s2.length)
    for (i in 0 until len) {
        if (s1[i] == s2[i]) sb.append(s1[i]) else break
    }
    return sb.toString()
}

fun longestCommonPrefix2(strs: Array<String>): String? {
    val len = strs.size
    if (len == 0) return ""
    if (len == 1) return strs[0]
    val len0 = strs[0].length
    if (len0 == 0) return ""
    val sb = StringBuffer()
    for (i in 0 until len0) {
        val c = strs[0][i]
        for (j in 1 until len) {
            if (strs[j].length < i + 1) return sb.toString()
            if (c != strs[j][i]) return sb.toString()
        }
        sb.append(c)
    }
    return sb.toString()
}