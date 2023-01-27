package main.kotlin.baekjoon

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val input = br.readLine().toInt()
    println(fibonacci(input))
}

fun fibonacci(n: Int): Int {
    return if(n > 1) {
        fibonacci(n-2) + fibonacci(n-1)
    } else if(n == 1) {
        1
    } else {
        0
    }
}