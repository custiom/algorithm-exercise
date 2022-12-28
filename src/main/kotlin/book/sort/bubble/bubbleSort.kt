package sort.bubble

fun main(args: Array<String>) {
    val n = 6
    val arr = mutableListOf(5,2,4,6,1,3)
    bubbleSort(n, arr)
}

fun bubbleSort(size: Int, inputs: MutableList<Int>) {
    var swapCount = 0
    for(i: Int in 1 .. size) {
        for(j: Int in size - 1 downTo  i) {
            if(inputs[j] < inputs[j-1]) {
                val tempValue = inputs[j]
                inputs[j] = inputs[j-1]
                inputs[j-1] = tempValue
                swapCount++
            }
        }
    }

    println(inputs)
    println(swapCount)
}