fun main(args: Array<String>) {
    println(solution(3, arrayOf(1, 1, 1).toIntArray()))
}

fun solution(N: Int, stages: IntArray): IntArray {
    val hash = HashMap<Int, Int>()
    val result = HashMap<Int, Float>()
    var next = stages.size;
    for(i:Int in stages.indices) {
        hash[stages[i]] = hash.getOrDefault(stages[i], 0) + 1
    }

    for (i: Int in 1 ..  N) {
        result[i] = if(next != 0) hash.getOrDefault(i, 0).toFloat() / next else 0F
        next -= hash.getOrDefault(i, 0)
    }
    return result.toList().sortedWith(compareByDescending<Pair<Int, Float>> {it.second}.thenBy { it.first }).map { it.first }.toIntArray()
}