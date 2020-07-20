package com.shouzhong.leetcode

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 */
fun isPalindrome(x: Int): Boolean {
    var x = x
    if (x < 0 || x % 10 == 0 && x > 0) return false
    var temp = 0
    while (x > temp) {
        temp = temp * 10 + x % 10
        x /= 10
    }
    return x == temp || x == temp / 10
}