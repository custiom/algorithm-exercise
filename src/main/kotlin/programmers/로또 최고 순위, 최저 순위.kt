package programmers

import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    println(solution(intArrayOf(44, 1, 0, 0, 31, 25), intArrayOf(31, 10, 45, 1, 6, 19)))
}

fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
    val matchCount = win_nums.count { lottos.contains(it) }
    val magicNumberCount = lottos.count { it == 0 }
    val highRank = if (7 - (matchCount + magicNumberCount) >= 6) 6 else 7 - (matchCount + magicNumberCount)
    val lowRank = if(7 - matchCount >= 6) 6 else 7 - matchCount
    return intArrayOf(highRank, lowRank)
}