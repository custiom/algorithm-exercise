package main.kotlin.baekjoon

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (houseSize, wifiCount) = br.readLine().split(" ").map { it.toInt() }
    val houses = IntArray(houseSize) { 0 }

    for (i: Int in 0 until houseSize) {
        houses[i] = br.readLine().toInt()
    }
    houses.sort()

    var left = 1
    var right = houses[houseSize-1] - houses[0]
    var answer = 1
    while (left <= right) {
        val mid = (left + right) / 2
        var router = 1
        var flagIndex = 0
        for (i: Int in 1 until houseSize) {
            if(houses[i] - houses[flagIndex] >= mid) {
                router++
                flagIndex = i
            }
        }
        if(router >= wifiCount) {
            answer = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    println(answer)
    br.close()
}