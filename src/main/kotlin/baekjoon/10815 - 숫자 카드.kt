package main.kotlin.baekjoon

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val myCardSize = br.readLine().toInt()
    val myCards = br.readLine().split(" ").map { it.toInt() }.sorted()
    val exampleSize = br.readLine().toInt()
    val exampleCards = br.readLine().split(" ").map { it.toInt() }
    val result = IntArray(exampleSize) { 0 }

    fun check(value: Int): Boolean {
        var left = 0
        var right = myCardSize
        var mid = 0
        while(right > left) {
            mid = (left + right) / 2
            if(myCards[mid] == value) {
                return true
            } else if(myCards[mid] > value) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return false
    }

    exampleCards.forEachIndexed { index, i ->
        if (check(i)) {
            result[index] = 1
        }
    }

    println(result.joinToString(" "))
}