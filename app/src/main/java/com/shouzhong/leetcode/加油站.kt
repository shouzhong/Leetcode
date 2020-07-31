package com.shouzhong.leetcode

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    val len = gas.size
    var current = 0
    var total = 0
    var index = 0
    for (i in 0 until len) {
        val temp = gas[i] - cost[i]
        total += temp
        current += temp
        if (current < 0) {
            index = i + 1
            current = 0
        }
    }
    return if (total >= 0) index else -1
}