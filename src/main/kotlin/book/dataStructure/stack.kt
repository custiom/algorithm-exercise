package main.kotlin.book.dataStructure

import java.util.*

fun main(args: Array<String>) {
    val infoArray = readLine()!!.trim().split(" ")
    val stack  = Stack<Int>()
    infoArray.forEach {
        when(it) {
            "+" -> stack.push(stack.pop().toInt() + stack.pop().toInt())
            "-" -> stack.push(-stack.pop().toInt() + stack.pop().toInt())
            "*" -> stack.push(stack.pop().toInt() * stack.pop().toInt())
            else -> stack.push(it.toInt())
        }
    }

    println(stack.pop())
}
