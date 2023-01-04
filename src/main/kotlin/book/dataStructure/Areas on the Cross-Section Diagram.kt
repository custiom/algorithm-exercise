package main.kotlin.book.dataStructure

import java.util.*

fun main(args: Array<String>) {
    val inputArray = readLine()!!.trim().split("")
    val indexStack = Stack<Int>()
    val sumStack = Stack<Pair<Int, Int>>()
    var flagValue: Pair<Int, Int>? = null
    var sum = 0
    val resultList = mutableListOf<Int>()

    inputArray.forEachIndexed { index, it ->
        when(it) {
            "\\" -> {
                indexStack.push(index)
            }
            "/" -> {
                if(indexStack.isNotEmpty()) {
                    val pairIndex = indexStack.pop()
                    val size = index - pairIndex
                    sumStack.push(Pair(pairIndex, size))
                }
            }
        }
    }


    while(sumStack.isNotEmpty()) {
        if (flagValue == null) {
             flagValue = sumStack.pop()
        } else {
            val currentValue = sumStack.pop()
            if(flagValue.first < currentValue.first) {
                sum += currentValue.second
            } else {
                sum += flagValue.second
                resultList.add(sum)
                sum = 0
                flagValue = currentValue
            }
            if(sumStack.isEmpty()) {
                sum += flagValue?.second ?: 0
                if(sum != 0) {
                    resultList.add(sum)
                }
            }
        }
    }

    println(resultList.sum())
    println("${resultList.size} ${resultList.reversed().joinToString(" ")}")
}