package main.kotlin.baekjoon

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (k, n) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }

    var left = 0
    var right = arr.maxOf { it }
    var answer = 0

    while (left <= right) {
        val mid = (left + right) / 2
        var sum = 0L
        for (i: Int in 0 until k) {
            if (arr[i] - mid > 0) {
                sum += arr[i] - mid
            }
        }
        if(sum >= n) {
            left = mid + 1
            answer = mid
        } else {
            right = mid - 1
        }
    }
    println(answer)
}