package main.kotlin.baekjoon

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (lectureSize, bluelaySize) = br.readLine().split(" ").map { it.toInt() }
    val lectures = br.readLine().split(" ").map { it.toInt() }
    var left = 0
    var right = lectures.sum()
    var mid = 0

    fun checkSize(flag: Int): Int {
        var i = 0
        for (j: Int in 0 until bluelaySize) {
            var s = 0;
            while (s + lectures[i] <= flag) {
                s += lectures[i]
                i++
                if (i == lectureSize) return bluelaySize
            }
        }
        return 0
    }

    fun solve(): Int {
        while (right - left > 1) {
            mid = (left + right) / 2
            val v = checkSize(mid)
            if(v >= bluelaySize) {
                right = mid
            } else {
                left = mid
            }
        }

        return right
    }

    println(solve())
}