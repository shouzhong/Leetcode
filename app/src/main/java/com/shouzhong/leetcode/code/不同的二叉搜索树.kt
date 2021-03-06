package com.shouzhong.leetcode.code

import com.shouzhong.leetcode.code.TreeNode
import java.util.*

fun generateTrees(n: Int): List<TreeNode?>? {
    return if (n == 0) {
        LinkedList()
    } else generateTrees(1, n)
}

fun generateTrees(start: Int, end: Int): List<TreeNode?> {
    val allTrees: MutableList<TreeNode?> = LinkedList()
    if (start > end) {
        allTrees.add(null)
        return allTrees
    }
    for (i in start..end) {
        val leftTrees = generateTrees(start, i - 1)
        val rightTrees = generateTrees(i + 1, end)
        for (left in leftTrees) {
            for (right in rightTrees) {
                allTrees.add(
                    TreeNode(
                        i,
                        left,
                        right
                    )
                )
            }
        }
    }
    return allTrees
}