package com.shouzhong.leetcode

import java.util.*

/**
 * 无重复字符的最长子串
 *
 */
fun lengthOfLongestSubstring(s: String?): Int {
    val len = s?.length ?: 0
    if (len <= 1) return len
    var size = 0
    var start = 0
    val map: MutableMap<Char, Int> = HashMap()
    for (i in 0 until len) {
        val c = s!![i]
        val temp = map[c]
        if (temp == null || temp < start) {
            size = Math.max(size, i - start + 1)
        } else {
            start = temp + 1
        }
        map[c] = i
    }
    return size
}