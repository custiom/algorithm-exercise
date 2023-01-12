package main.kotlin.baekjoon

fun main(args: Array<String>) {
    data class PairShort(val index: Short, val point: Short)
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val size = br.readLine()!!.trim().toInt()
    val deque = ArrayDeque<PairShort>()
    deque.addAll(br.readLine()!!.trim().split(" ").mapIndexed{ index, s -> PairShort((index + 1).toShort(), s.toShort()) })

    bw.write("1 ")
    var move = deque.removeFirst().point
    while (deque.isNotEmpty()) {
        val (index, point) = if(move > 0) {
            for (j: Int in 0 until move) {
                deque.addLast(deque.removeFirst())
            }
            deque.removeLast()
        } else {
            for (j: Int in move until  0) {
                deque.addFirst(deque.removeLast())
            }
            deque.removeFirst()
        }
        bw.write("$index ")
        move = point
    }
    bw.close()
    br.close()
}

