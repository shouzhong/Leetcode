package com.shouzhong.leetcode.code

import java.util.*

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 */
fun cloneGraph(node: Node?): Node? {
    val visited =
        HashMap<Node, Node>()
    return cloneGraph(visited, node)
}

fun cloneGraph(
    visited: HashMap<Node, Node>,
    node: Node?
): Node? {
    if (node == null) return null
    if (visited.containsKey(node)) return visited[node]
    val clone = Node(
        node.`val`,
        ArrayList()
    )
    visited[node] = clone
    for (temp in node.neighbors) {
        clone.neighbors.add(cloneGraph(visited, temp))
    }
    return clone
}