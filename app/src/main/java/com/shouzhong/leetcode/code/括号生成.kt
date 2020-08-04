package com.shouzhong.leetcode.code

import java.util.*

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 */
fun generateParenthesis(n: Int): List<String>? {
    val list: MutableList<String> = ArrayList()
    if (n <= 0) return list
    generateParenthesis(list, "", n, n)
    return list
}

private fun generateParenthesis(
    list: MutableList<String>,
    s: String,
    left: Int,
    right: Int
) {
    if (left == 0 && right == 0) {
        list.add(s)
        return
    }
    if (left > 0) {
        generateParenthesis(list, "$s(", left - 1, right)
    }
    if (right > left) {
        generateParenthesis(list, "$s)", left, right - 1)
    }
}