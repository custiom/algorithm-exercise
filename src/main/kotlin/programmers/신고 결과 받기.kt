package programmers

fun main(args: Array<String>) {
    println(solution(arrayOf("muzi", "frodo", "apeach", "neo"), arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"), 2))
}

fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    val hash = hashMapOf<String, MutableSet<String>>()
    id_list.forEach {
        hash[it] = mutableSetOf()
    }

    report.forEach {
        val reporter = it.split(" ").first()
        val receiver = it.split(" ").last()
        hash[receiver]!!.plusAssign(reporter)
    }
    val newResult = hash.filter { it.value.size >= k }.values.flatten().groupBy { it }

    return id_list.map { if(newResult.contains(it)) newResult[it]!!.size else 0 }.toIntArray()
}