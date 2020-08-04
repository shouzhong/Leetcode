package com.shouzhong.leetcode.code

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var index = m + n - 1
    var index1 = m - 1
    var index2 = n - 1
    while (index2 >= 0) {
        if (index1 < 0) {
            nums1[index--] = nums2[index2--]
        } else {
            val n1 = nums1[index1]
            val n2 = nums2[index2]
            if (n1 > n2) {
                nums1[index--] = n1
                index1--
            } else {
                nums1[index--] = n2
                index2--
            }
        }
    }
}