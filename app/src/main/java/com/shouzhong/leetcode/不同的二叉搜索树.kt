package com.shouzhong.leetcode

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
                allTrees.add(TreeNode(i, left, right))
            }
        }
    }
    return allTrees
}

class TreeNode {
    var `val` = 0
    var left: TreeNode? = null
    var right: TreeNode? = null

    internal constructor() {}
    internal constructor(`val`: Int) {
        this.`val` = `val`
    }

    internal constructor(`val`: Int, left: TreeNode?, right: TreeNode?) {
        this.`val` = `val`
        this.left = left
        this.right = right
    }
}