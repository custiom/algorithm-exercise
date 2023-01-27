package main.kotlin.baekjoon

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val input = br.readLine().toInt()
    println(factorial(input))
}

fun factorial(n: Int): Int {
    return if(n == 1) {
        1
    } else if(n == 0) {
        1
    } else {
        factorial(n -1) * n
    }
}