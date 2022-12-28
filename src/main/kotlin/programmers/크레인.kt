package programmers

import java.util.Stack


fun main(args: Array<String>) {
    println(solution(
        arrayOf(intArrayOf(0,0,0,0,0),
            intArrayOf(0,0,1,0,3),
            intArrayOf(0,2,5,0,1),
            intArrayOf(4,2,4,4,2),
            intArrayOf(3,5,1,3,1)),
            intArrayOf(1,5,3,5,1,2,1,4)))
}

fun solution(board: Array<IntArray>, moves: IntArray): Int {
    val stackArray = Array(board.size) { Stack<Int>() }
    val pocket = mutableListOf<Int>()
    var result = 0
    for(i:Int in board.size -1 downTo 0 step 1) {
        for (j: Int in board.indices) {
            if(board[i][j] != 0) {
                stackArray[j].push(board[i][j])
            }
        }
    }

    moves.forEach {
        if(stackArray[it-1].isNotEmpty()) {
            val element = stackArray[it-1].pop()
            if((pocket.lastOrNull()) != element) {
                pocket.add(element)
            } else if(pocket.last() == element) {
                pocket.removeLast()
                result += 2
            }
        }
    }

    return result
}