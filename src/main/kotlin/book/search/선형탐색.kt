package main.kotlin.book.search

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val size = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    val searchSize = br.readLine().toInt()
    val searchInputs = br.readLine().split(" ").map { it.toInt() }
    var sum = 0;

    fun searchValue(value: Int): Int {
        for (i: Int in 0 until size) {
            if(inputs[i] == value) return 1
        }
        return 0
    }

    for (i: Int in 0 until searchSize) {
        sum += searchValue(searchInputs[i])
    }

    println(sum)
}