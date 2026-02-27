package com.practice.binarysearch

class TwoDimensionBinarySearchWithSortedArray {
    companion object {

        private fun search(matrix: Array<IntArray>, target: Int): IntArray {
            var row = 0
            var col = matrix[0].size - 1

            while (row < matrix.size && col >= 0) {
                val value = matrix[row][col]
                if (value == target) {
                    return intArrayOf(row, col)
                }
                if (value < target) {
                    row++
                } else {
                    col--
                }
            }
            return intArrayOf(-1, -1)
        }
        @JvmStatic
        fun main(args: Array<String>) {
            val array = arrayOf(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(6, 7, 8, 9, 10),
                intArrayOf(11, 12, 13, 14, 15),
                intArrayOf(16, 17, 18, 19, 20),
            )
            println("Index = " + search(array, 9).contentToString())
        }
    }
}
