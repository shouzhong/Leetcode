package com.shouzhong.leetcode.code

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 1. "123"
 * 2. "132"
 * 3. "213"
 * 4. "231"
 * 5. "312"
 * 6. "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 */
fun getPermutation(n: Int, k: Int): String? {
    var n = n
    var k = k
    val `is` = intArrayOf(0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800)
    val temp = StringBuffer("123456789".substring(0, n))
    val sb = StringBuffer()
    k--
    while (k > 0) {
        val i = k / `is`[n - 1]
        sb.append(temp[i])
        temp.replace(i, i + 1, "")
        k %= `is`[n - 1]
        n--
    }
    return sb.toString() + temp.toString()
}