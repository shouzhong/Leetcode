package com.shouzhong.leetcode

import java.util.*

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 */
fun isValid(s: String?): Boolean {
    val len = s?.length ?: 0
    if (len % 2 == 1) return false
    val stack = Stack<Char>()
    for (i in 0 until len) {
        val c = s!![i]
        val temp = getValidChar(c)
        if (temp != '#') {
            val top = if (stack.isEmpty()) '#' else stack.pop()
            if (top != temp) return false
        } else {
            stack.push(c)
        }
    }
    return stack.isEmpty()
}

private fun getValidChar(c: Char): Char {
    return when (c) {
        ')' -> '('
        ']' -> '['
        '}' -> '{'
        else -> '#'
    }
}