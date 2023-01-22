package main.kotlin.book.search

fun main(args: Array<String>) {
    val trucks = IntArray(100000) {0}

    val br = System.`in`.bufferedReader()
    val inputs = br.readLine().toString().split(" ").map { it.toInt() }

    val productSize = inputs[0]
    val truckSize = inputs[1]

    fun check(flag: Long): Long {
        var i = 0L
        for(j: Int in 0 until truckSize) {
            var s = 0L;
            while (s + trucks[i.toInt()] <= flag) {
                s += trucks[i.toInt()]
                i++
                if(i==productSize.toLong()) return productSize.toLong()
            }
        }
        return i
    }

    fun solve(): Long {
        var left = 0L
        var right = 100000 * 10000L
        var mid = 0L
        while (right - left > 1) {
            mid = (left + right) / 2
            val v = check(mid)
            if(v >= productSize) right = mid;
            else left = mid
        }

        return right
    }

    for (i: Int in 0 until productSize) {
        trucks[i] = br.readLine().toInt()
    }

    println(solve())
}

