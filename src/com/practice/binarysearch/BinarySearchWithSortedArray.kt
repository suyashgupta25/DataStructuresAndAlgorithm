package com.practice.binarysearch

class BinarySearchWithSortedArray {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            //    val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 15)
            val array = arrayOf(15, 9, 8, 7, 6, 5, 4, 3, 2, 1)
            System.out.println("Index = "+ binarySearch(array, 1))
        }

        private fun binarySearch(array: Array<Int>, target: Int): Int {
            var start = 0
            var end = array.lastIndex
            val isAsc = array[start] < array[end]

            while (start <= end) {
                val mid = start + (end - start) / 2
                if(array[mid] == target) {
                    return mid
                }
                if(isAsc) {
                    if(array[mid] > target) {
                        end = mid - 1
                    } else {
                        start = mid + 1
                    }
                } else {
                    if(array[mid] > target) {
                        start = mid + 1
                    } else {
                        end = mid - 1
                    }
                }
            }
            return -1
        }
    }
}
