package com.shouzhong.leetcode.code

/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 */
fun strStr(haystack: String, needle: String): Int {
    val haystackLen = haystack.length
    val needleLen = needle.length
    if (needleLen == 0) return 0
    if (needleLen > haystackLen) return -1
    val len = haystackLen - needleLen + 1
    for (i in 0 until len) {
        var boo = true
        for (j in 0 until needleLen) {
            if (haystack[i + j] != needle[j]) {
                boo = false
                break
            }
        }
        if (boo) return i
    }
    return -1
}