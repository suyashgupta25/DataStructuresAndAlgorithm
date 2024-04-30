fun main() {
    val array = arrayOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(6, 7, 8, 9, 10),
        intArrayOf(11, 12, 13, 14, 15),
        intArrayOf(16, 17, 18, 19, 20),
    )
    println("Index = " + search2(array, 20).contentToString())
}

fun search2(array: Array<IntArray>, target: Int): IntArray {
    var row = 0
    var col = array[0].size - 1

    while (row < array.size && col >= 0) {
        val value = array[row][col]
        if (value == target) {
            return intArrayOf(row, col)
        }

        if (value > target) {
            col--
        } else {
            row++
        }
    }
    return intArrayOf(-1, -1)
}
