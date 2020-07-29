package com.shouzhong.leetcode

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 */
fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val left = maxDepth(root.left)
    val right = maxDepth(root.right)
    return left.coerceAtLeast(right) + 1
}