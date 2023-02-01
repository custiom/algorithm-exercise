package main.kotlin.baekjoon

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (k, n) = br.readLine().split(" ").map { it.toInt() }
    val arr = IntArray(k) { 0 }

    for(i: Int in 0 until k) {
        arr[i] = br.readLine().toInt()
    }


    var left = 0L
    var right = Int.MAX_VALUE
    var answer = 0;
    while (left <= right) {
        var count = 0
        val mid: Long = (left + right.toLong()) / 2
        loop@ for (i: Int in 0 until  k) {
            var sum = 0L
            while(sum + mid <= arr[i]) {
                sum += mid
                count++
                if(count > n) {
                    break@loop
                }
            }
        }
        if (count >= n) {
            left = mid + 1
            answer = mid.toInt()
        } else {
            right = mid.toInt() - 1
        }
    }

    println(answer)
}