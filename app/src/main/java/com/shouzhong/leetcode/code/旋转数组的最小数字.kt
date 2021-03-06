package com.shouzhong.leetcode.code

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1
 *
 */
fun minArray(numbers: IntArray): Int {
    var low = 0
    var high = numbers.size - 1
    while (low < high) {
        val index = low + (high - low) / 2
        when {
            numbers[index] < numbers[high] -> {
                high = index
            }
            numbers[index] > numbers[high] -> {
                low = index + 1
            }
            else -> {
                high -= 1
            }
        }
    }
    return numbers[low]
}