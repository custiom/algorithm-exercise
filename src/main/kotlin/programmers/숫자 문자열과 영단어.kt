package programmers

fun main(args: Array<String>) {
    println(solution("one4seveneight"))
}

fun solution(s: String): Int {
    var result = ""
    val hash = hashMapOf(
        Pair("zero", "0"),
        Pair("one", "1"),
        Pair("two", "2"),
        Pair("three", "3"),
        Pair("four", "4"),
        Pair("five", "5"),
        Pair("six", "6"),
        Pair("seven", "7"),
        Pair("eight", "8"),
        Pair("nine", "9"),
    )
    var storage = ""

    for (i: Int in s.indices) {
        if(s[i] >= Char(48) && s[i] <= Char(57)) {
            result += ((if(hash[storage]!= null) hash[storage] else "") + s[i])
            storage = ""
        } else {
            storage += s[i]
            if(hash[storage]!= null) {
                result += hash[storage]
                storage = ""
            }
        }
    }


    return result.toInt()
}