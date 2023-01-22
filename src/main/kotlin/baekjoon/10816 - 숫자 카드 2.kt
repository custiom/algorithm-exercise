package main.kotlin.baekjoon

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val myCardSize = br.readLine().toInt()
    val myCards = br.readLine().split(" ").map { it.toInt() }.sorted()
    val exampleSize = br.readLine().toInt()
    val exampleCards = br.readLine().split(" ").map { it.toInt() }
    val hash = hashMapOf<Int, Int>()
    val result = IntArray(exampleSize) { 0 }

    myCards.forEach {
        hash[it] = hash.getOrDefault(it, 0) + 1
    }
    exampleCards.forEachIndexed { index, i ->
        result[index] = hash.getOrDefault(i, 0)

    }

    bw.write(result.joinToString(" "))
    bw.close()
    br.close()
}