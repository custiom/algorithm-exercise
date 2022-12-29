package main.kotlin.book.dataStructure



fun main(args: Array<String>) {
    val queue = main.kotlin.book.dataStructure.RingBuffer(7)
    val infoArray = readLine()!!.trim().split(" ").map { it.toInt() }
    val q = infoArray[1]
    var time = 0
    val result = mutableListOf<Pair<String, Int>>()
    for(i: Int in 0 until  infoArray[0]) {
        val input = readLine()!!.trim().split(" ")
        queue.enqueue(Pair(input[0], input[1].toInt()))
    }

    while (!queue.isEmpty()) {
        val value = queue.dequeue()
        if(value.second > q) {
            time += q
            queue.enqueue(Pair(value.first, value.second - q))
        } else {
            time += value.second
            result.add(Pair(value.first, time))
        }
    }
    result.forEach{
        println("${it.first} ${it.second}")
    }
}


class RingBuffer(
    private val size: Int
) {
    private var head: Int = 0
    private var tail: Int = 0
    private val queue: Array<Pair<String, Int>>
    init {
        head = 0
        tail = 0
        queue = Array(size) { Pair("", 0) }
    }

    private fun isFull(): Boolean {
        return head == (tail + 1) % size
    }

    fun isEmpty(): Boolean {
        return head == tail
    }

    fun enqueue(x: Pair<String, Int>) {
        if(isFull()) {
            throw Error("enqueue")
        } else {
            queue[tail++] = x
            if (tail == size) {
                tail = 0
            }
        }
    }

    fun dequeue(): Pair<String, Int> {
        return if(isEmpty()) {
            throw Error("dequeue")
        } else {
            val result = queue[head++]
            if (head == size) {
                head = 0
            }
            result
        }

    }
}

