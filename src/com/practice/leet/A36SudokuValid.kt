package com.practice.leet


//hashset
fun checkSet(board: Array<CharArray>): Boolean {
    val rowSet = MutableList(9) { mutableSetOf<Char>() }
    val colSet = MutableList(9) { mutableSetOf<Char>() }
//    val gridSet = mutableMapOf<Pair<Int, Int>, MutableSet<Char>>()

    for (rowIndex in board.indices) {
        val chars = board[rowIndex]
        val localRowSet = rowSet.elementAtOrNull(rowIndex) ?: mutableSetOf()

        for (colIndex in 0..<chars.size) {
            val char = chars[colIndex]
            if(char == '.') {
                continue
            }
            val localColSet = colSet.elementAtOrNull(colIndex) ?: mutableSetOf()

            val pair = Pair(rowIndex/ 3, colIndex/ 3)
//            val localGridSet = gridSet[pair] ?: mutableSetOf()

            if(localRowSet.contains(char)) {
                return false
            }
            if(localColSet.contains(char)) {
                return false
            }
//            if(localGridSet.contains(char)) {
//                return false
//            }

            localRowSet.add(char)
            localColSet.add(char)
//            localGridSet.add(char)
//            gridSet[pair] = localGridSet
        }
    }

    return true
}

// hashmap
private val map = mutableMapOf<Cell, Char>()

data class Cell (val row:Int, val col:Int, val quad: Int)
fun isValidSudoku(board: Array<CharArray>): Boolean {

    for (arrayIndex in board.indices) {
        val chars = board[arrayIndex]
        for (charIndex in 0..<chars.size) {
            val char = chars[charIndex]
            map[Cell(arrayIndex,charIndex, quadValue(arrayIndex, charIndex))] = char
        }
    }

    return checkSet(board)
}

fun check(board: Array<CharArray>): Boolean {
    for (rowIndex in board.indices) {
        val chars = board[rowIndex]
        for (colIndex in 0..<chars.size) {
            val charRowValue = chars[colIndex]
            val cellInCheck = Cell(rowIndex,colIndex, quadValue(rowIndex,colIndex))
            for (counter in board.indices) {
                val cellAtCol = Cell(rowIndex, counter, quadValue(rowIndex,counter))
                val cellAtRow = Cell(counter, colIndex, quadValue(counter,colIndex))

                val colValueMap = map[cellAtCol]
                val rowValueMap = map[cellAtRow]
                if(cellAtRow != cellInCheck && rowValueMap == charRowValue && rowValueMap != '.') {
                    return false
                }
                if(cellAtCol != cellInCheck && colValueMap == charRowValue && colValueMap != '.') {
                    return false
                }
                if(!chekSubBox(cellInCheck)) return false
            }
        }
    }
    return true
}

fun chekSubBox(cellInCheck: Cell): Boolean {
    val filter = map.filter { cellInCheck.quad == it.key.quad }
    filter.entries.forEach { (cell, value) ->
        if(cell != cellInCheck && value == map[cellInCheck] && value != '.') {
            return false
        }
    }
    return true
}

fun quadValue(rowIndex: Int, colIndex: Int): Int {
    if(rowIndex / 3 == 0 && colIndex / 3 == 0 ) {
        return 1
    }
    if(rowIndex / 3 == 1 && colIndex / 3 == 0 ) {
        return 2
    }
    if(rowIndex / 3 == 2 && colIndex / 3 == 0 ) {
        return 3
    }
    if(rowIndex / 3 == 0 && colIndex / 3 == 1 ) {
        return 4
    }
    if(rowIndex / 3 == 1 && colIndex / 3 == 1 ) {
        return 5
    }
    if(rowIndex / 3 == 2 && colIndex / 3 == 1 ) {
        return 6
    }
    if(rowIndex / 3 == 0 && colIndex / 3 == 2 ) {
        return 7
    }
    if(rowIndex / 3 == 1 && colIndex / 3 == 2 ) {
        return 8
    }
    if(rowIndex / 3 == 2 && colIndex / 3 == 2 ) {
        return 9
    }
    return 0
}

val boardData: Array<CharArray> = arrayOf(
    charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
)

//private val boardData: Array<CharArray> = arrayOf(
//    charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
//    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
//    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
//    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
//    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
//    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
//    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
//    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
//    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
//)




fun main() {
    println(isValidSudoku(boardData))
}

