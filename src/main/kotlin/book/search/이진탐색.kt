package main.kotlin.book.search

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val size = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    val searchSize = br.readLine().toInt()
    val searchInputs = br.readLine().split(" ").map { it.toInt() }
    var sum = 0;

    fun binarySearch(list: List<Int>, key: Int): Int{
        var left = 0
        var right = list.size
        var mid = (left + right) / 2
        while (left < right) {
            if(list[mid] == key) {
                return 1
            } else if(list[mid] > key) {
                right = mid
                mid = (left + right) / 2
            } else {
                left = mid + 1
                mid = (left + right) / 2
            }
        }
        return 0
    }

    for (i: Int in 0 until searchSize) {
       sum += binarySearch(inputs, searchInputs[i])
    }

    println(sum)
}