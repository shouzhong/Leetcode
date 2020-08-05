package com.shouzhong.leetcode.code

import java.util.*

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 */
fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val edges: MutableList<MutableList<Int>> =
        ArrayList()
    for (i in 0 until numCourses) {
        edges.add(ArrayList())
    }
    val visited = IntArray(numCourses)
    for (temp in prerequisites) {
        edges[temp[1]].add(temp[0])
    }
    val bs = booleanArrayOf(true)
    var i = 0
    while (i < numCourses && bs[0]) {
        if (visited[i] == 0) canFinish(edges, visited, bs, i)
        i++
    }
    return bs[0]
}

fun canFinish(
    edges: List<MutableList<Int>>,
    visited: IntArray,
    bs: BooleanArray,
    u: Int
) {
    visited[u] = 1
    for (v in edges[u]) {
        if (visited[v] == 0) {
            canFinish(edges, visited, bs, v)
            if (!bs[0]) return
        } else if (visited[v] == 1) {
            bs[0] = false
            return
        }
    }
    visited[u] = 2
}