package com.shouzhong.leetcode

import java.util.*

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * 格雷编码序列必须以 0 开头。
 *
 */
fun grayCode(n: Int): List<Int>? {
    val res: MutableList<Int> = ArrayList()
    res.add(0)
    var head = 1
    for (i in 0 until n) {
        for (j in res.indices.reversed()) res.add(head + res[j])
        head = head shl 1
    }
    return res
}