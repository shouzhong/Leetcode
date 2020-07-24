package com.shouzhong.leetcode

import java.util.*

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val set: MutableSet<Char> = HashSet()
    for (i in 0..8) {
        set.clear()
        for (j in 0..8) {
            if (board[i][j] in '0'..'9') {
                val boo = set.add(board[i][j])
                if (!boo) return false
            }
        }
        set.clear()
        for (j in 0..8) {
            if (board[j][i] in '0'..'9') {
                val boo = set.add(board[j][i])
                if (!boo) return false
            }
        }
        set.clear()
        for (j in 0..8) {
            val i1 = i / 3 * 3 + j / 3
            val i2 = i % 3 * 3 + j % 3
            if (board[i1][i2] in '0'..'9') {
                val boo = set.add(board[i1][i2])
                if (!boo) return false
            }
        }
    }
    return true
}

fun isValidSudoku2(board: Array<CharArray>): Boolean {
    val set1: MutableSet<Char> = HashSet()
    val set2: MutableSet<Char> = HashSet()
    val set3: MutableSet<Char> = HashSet()
    for (i in 0..8) {
        set1.clear()
        set2.clear()
        set3.clear()
        for (j in 0..8) {
            if (board[i][j] in '0'..'9') {
                val boo = set1.add(board[i][j])
                if (!boo) return false
            }
            if (board[j][i] in '0'..'9') {
                val boo = set2.add(board[j][i])
                if (!boo) return false
            }
            val i1 = i / 3 * 3 + j / 3
            val i2 = i % 3 * 3 + j % 3
            if (board[i1][i2] in '0'..'9') {
                val boo = set3.add(board[i1][i2])
                if (!boo) return false
            }
        }
    }
    return true
}