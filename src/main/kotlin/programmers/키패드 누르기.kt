package programmers

fun main(args: Array<String>) {
    println(solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"))
}

fun solution(numbers: IntArray, hand: String): String {
    var answer = ""

    for (i: Int in numbers.indices) {
        if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
            answer += "L"
        }
        if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
            answer += "R"
        }
    }
    return answer
}