package com.shouzhong.leetcode

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 */
fun isPalindrome(s: String): Boolean {
    val len = s.length
    var left = 0
    var right = len - 1
    while (left < right) {
        var c1 = s[left]
        var c2 = s[right]
        if (c1 < '0' || c1 > '9' && c1 < 'A' || c1 > 'Z' && c1 < 'a' || c1 > 'z') {
            left++
        } else if (c2 < '0' || c2 > '9' && c2 < 'A' || c2 > 'Z' && c2 < 'a' || c2 > 'z') {
            right--
        } else {
            if (c1 >= 'A' && c1 <= 'Z') c1 += 'a' - 'A'
            if (c2 >= 'A' && c2 <= 'Z') c2 += 'a' - 'A'
            if (c1 != c2) return false
            left++
            right--
        }
    }
    return true
}