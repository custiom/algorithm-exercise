package sort.insertion

fun main(args: Array<String>) {
    val n = 6
    val arr = mutableListOf(5,2,4,6,1,3)
    insertionSort(n, arr)
}

fun insertionSort(size: Int, inputs: MutableList<Int>) {
    for(i: Int in 1 .. size) {
        val v = inputs[i]
        var j = i-1
        while (j >= 0 && inputs[j] > v) {
            inputs[j+1] = inputs[j]
            j--
        }
        inputs[j+1] = v
        println(inputs)
    }


}