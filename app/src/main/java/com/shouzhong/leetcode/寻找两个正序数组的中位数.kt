package com.shouzhong.leetcode

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val length1 = nums1.size
    val length2 = nums2.size
    val totalLength = length1 + length2
    return if (totalLength % 2 == 1) {
        getMinElementAt(nums1, nums2, totalLength / 2 + 1).toDouble()
    } else {
        (getMinElementAt(nums1, nums2, totalLength / 2) + getMinElementAt(
            nums1,
            nums2,
            totalLength / 2 + 1
        )) / 2.0
    }
}

/**
 * 获取第几小的数据，从1开始算
 *
 * @param nums1
 * @param nums2
 * @param k
 * @return
 */
fun getMinElementAt(nums1: IntArray, nums2: IntArray, k: Int): Int {
    var k = k
    val len1 = nums1.size
    val len2 = nums2.size
    var index1 = 0
    var index2 = 0
    while (true) {
        if (index1 == len1) {
            return nums2[index2 + k - 1]
        }
        if (index2 == len2) {
            return nums1[index1 + k - 1]
        }
        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2])
        }
        val half = k / 2
        val newIndex1 = Math.min(index1 + half, len1) - 1
        val newIndex2 = Math.min(index2 + half, len2) - 1
        val p1 = nums1[newIndex1]
        val p2 = nums2[newIndex2]
        if (p1 < p2) {
            k -= newIndex1 - index1 + 1
            index1 = newIndex1 + 1
        } else {
            k -= newIndex2 - index2 + 1
            index2 = newIndex2 + 1
        }
    }
}