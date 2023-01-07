package main.kotlin.baekjoon

import java.util.Stack

fun main(args: Array<String>) {
    val size = readLine()!!.trim().toInt()
    val inputs = readLine()!!.trim().split(" ").map { it.toInt() }.asReversed()
    val stack = Stack<Int>()
    val result = mutableListOf<Int>()
    var previousValue = -1

    inputs.forEach {
        val max = stack.lastOrNull()
        if(max == null) {
            result.add(-1)
            stack.push(it)
            previousValue = it
        } else {
            if(previousValue > it) {
                stack.push(previousValue)
                result.add(previousValue)
                previousValue = it
            } else {
                if(max > it) {
                    result.add(max)
                } else {
                    stack.pop()
                    inner@ while(stack.isNotEmpty()) {
                        if(stack.last() > it) {
                            result.add(stack.last())
                            stack.push(it)
                            break@inner
                        } else {
                            stack.pop()
                        }
                    }
                    if(stack.lastOrNull() == null) {
                        result.add(-1)
                        stack.push(it)
                    }
                }
                previousValue = it
            }
        }
    }

    println(result.asReversed().joinToString(" "))
}