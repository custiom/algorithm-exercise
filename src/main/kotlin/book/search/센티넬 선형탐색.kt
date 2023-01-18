package main.kotlin.book.search

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val size = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    val searchSize = br.readLine().toInt()
    val searchInputs = br.readLine().split(" ").map { it.toInt() }
    var sum = 0;

    fun searchSentinel(value: Int): Int {
        var i = 0;
        while (i < size && inputs[i] != value ) {
            i++
        }
        return if(i == inputs.size) {
            0
        } else {
            1
        }
    }

    for (i: Int in 0 until searchSize) {
        sum += searchSentinel(searchInputs[i])
    }

    println(sum)
}