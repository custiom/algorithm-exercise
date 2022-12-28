package main.kotlin.baekjoon

fun main(args: Array<String>) {
    val infoArray = readLine()!!.trim().split(" ")
    val arr = mutableListOf<MutableList<Int>>()
    for(i: Int in 0 until infoArray[0].toInt()) {
        val inputArr = readLine()!!.trim().split(" ").map { it.toInt() }
        arr.add(inputArr.toMutableList())
    }

    println(sort(arr))
}

fun sort(arr: MutableList<MutableList<Int>>): Int {
    val list = arr.toMutableList()
    var count = 0
    for(i: Int in list.indices) {
        list[i] = list[i].toMutableList().sortedBy { it }.toMutableList()
    }
    for(i: Int in list.indices) {
        for(j: Int in i+1 until list.size) {
            var index = 0
            for(k: Int in 0 until  list[i].size) {
                if (arr[i].indexOf(list[i][k]) == arr[j].indexOf(list[j][k])) {
                    index++
                }
            }
            if(index == list[i].size) {
                count++
            }
        }
    }
    return count
}
