package com.shouzhong.leetcode.code

import java.util.*

/**
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 */
fun palindromePairs(words: Array<String>): List<List<Int>> {
    val lists: MutableList<List<Int>> = ArrayList()
    val map: MutableMap<String, Int> = HashMap()
    val len = words.size
    for (i in 0 until len) {
        map[StringBuilder(words[i]).reverse().toString()] = i
    }
    for (i in 0 until len) {
        val word = words[i]
        val n = word.length
        if (n == 0) continue
        for (j in 0..n) {
            if (palindromePairs(word, j, n - 1)) {
                val leftIndex = map[word.substring(0, j)]
                if (leftIndex != null && leftIndex != i) lists.add(listOf(i, leftIndex))
            }
            if (j != 0 && palindromePairs(word, 0, j - 1)) {
                val rightIndex = map[word.substring(j, n)]
                if (rightIndex != null && rightIndex != i) lists.add(listOf(rightIndex, i))
            }
        }
    }
    return lists
}

fun palindromePairs(s: String, left: Int, right: Int): Boolean {
    var left = left
    var right = right
    while (left < right) {
        if (s[left] != s[right]) return false
        left++
        right--
    }
    return true
}