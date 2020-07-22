package com.shouzhong.leetcode

import java.util.*

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 */
fun letterCombinations(digits: String): List<String>? {
    val list: MutableList<String> = ArrayList()
    val len = digits.length
    if (len == 0) return list
    letterCombinations(list, digits, "", 0)
    return list
}

private fun letterCombinations(
    list: MutableList<String>,
    digits: String,
    combin: String,
    index: Int
) {
    if (index == digits.length) {
        list.add(combin)
        return
    }
    val letter = letter(digits[index])
    for (element in letter) {
        letterCombinations(list, digits, combin + element, index + 1)
    }
}

private fun letter(c: Char): String {
    return when (c) {
        '2' -> "abc"
        '3' -> "def"
        '4' -> "ghi"
        '5' -> "jkl"
        '6' -> "mno"
        '7' -> "pqrs"
        '8' -> "tuv"
        '9' -> "wxyz"
        else -> ""
    }
}