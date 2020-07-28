package com.shouzhong.leetcode

import java.util.*

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 */
fun groupAnagrams(strs: Array<String>): List<MutableList<String>> {
    val lists: MutableList<MutableList<String>> =
        ArrayList()
    val len = strs.size
    if (len == 0) return lists
    val map: MutableMap<String, Int> = HashMap()
    var index = 0
    for (i in 0 until len) {
        val temp = strs[i].toCharArray()
        Arrays.sort(temp)
        val s = String(temp)
        val p = map[s]
        if (p == null) {
            map[s] = index++
            val list: MutableList<String> = ArrayList()
            list.add(strs[i])
            lists.add(list)
        } else {
            val list = lists[p]
            list.add(strs[i])
        }
    }
    return lists
}