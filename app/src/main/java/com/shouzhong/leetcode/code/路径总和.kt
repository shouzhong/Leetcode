package com.shouzhong.leetcode.code

import com.shouzhong.leetcode.code.TreeNode
import java.util.*

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 */
fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
    if (root == null) return false
    return if (root.left == null && root.right == null) {
        sum == root.`val`
    } else hasPathSum(root.left, sum - root.`val`) || hasPathSum(root.right, sum - root.`val`)
}

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 */
fun pathSum(
    root: TreeNode?,
    sum: Int
): List<List<Int>>? {
    val lists: MutableList<List<Int>> =
        ArrayList()
    pathSum(root, sum, lists, Stack())
    return lists
}

fun pathSum(
    root: TreeNode?,
    sum: Int,
    lists: MutableList<List<Int>>,
    stack: Stack<Int>
) {
    if (root == null) return
    stack.push(root.`val`)
    if (root.left == null && root.right == null && sum == root.`val`) {
        lists.add(ArrayList(stack))
    } else {
        pathSum(root.left, sum - root.`val`, lists, stack)
        pathSum(root.right, sum - root.`val`, lists, stack)
    }
    stack.pop()
}