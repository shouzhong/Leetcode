package com.shouzhong.leetcode.code

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 */
fun isSameTree(
    p: TreeNode?,
    q: TreeNode?
): Boolean {
    if (p == null && q == null) return true
    return if (p == null || q == null) false else p.`val` == q.`val` && isSameTree(
        p.left,
        q.left
    ) && isSameTree(p.right, q.right)
}