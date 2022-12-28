package baekjoon

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()
    val arr = mutableListOf<Int>()
    for(i: Int in 0 until n) {
        val input = readLine()!!.trim().toInt()
        arr.add(input)
    }

    sort(n, arr)
    printList(arr)
}

fun sort(size: Int, list: MutableList<Int>) {
    for(i: Int in 1 until size) {
        for(j: Int in size-1 downTo i) {
            if (list[j-1] > list[j]) {
                val temp = list[j-1]
                list[j-1] = list[j]
                list[j] = temp
            }
        }
    }
}

fun printList(list: List<Int>) {
    list.forEach { println(it) }
}