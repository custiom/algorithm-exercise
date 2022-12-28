package sort.selection

fun main(args: Array<String>) {
    val n = 6
    val arr = mutableListOf(5, 6, 4, 2, 1, 3)
    selectionSort(n, arr)
}

fun selectionSort(size: Int, inputs: MutableList<Int>) {
    var swapCount = 0
    for(i: Int in 0 until  size - 1) {
        var minIndex = i
        for (j: Int in i until size) {
            if(inputs[minIndex] > inputs[j]) {
                minIndex = j
            }
        }
        if(i != minIndex) {
            val tempValue = inputs[i]
            inputs[i] = inputs[minIndex]
            inputs[minIndex] = tempValue
            swapCount++
        }
    }

    println(inputs)
    println(swapCount)
}