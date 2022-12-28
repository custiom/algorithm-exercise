package programmers

import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    println(solution(arrayOf("TR", "RT", "TR"), arrayOf(7, 1, 3).toIntArray()))
}

fun solution(survey: Array<String>, choices: IntArray): String {
    val personality = hashMapOf<Char, Int>(
        Pair('R', 0),
        Pair('T', 0),
        Pair('C', 0),
        Pair('F', 0),
        Pair('J', 0),
        Pair('M', 0),
        Pair('A', 0),
        Pair('N', 0),
    )
    for(i: Int in survey.indices) {
        val score = 4 - choices[i]
        if(score < 0) {
            personality[survey[i].last()] = personality[survey[i].last()]!! + score.absoluteValue
        } else if (score > 0) {
            personality[survey[i].first()] = personality[survey[i].first()]!! + score.absoluteValue
        }
    }

    return (if(personality['R']!! >= personality['T']!!) "R" else "T") +
        (if(personality['C']!! >= personality['F']!!) "C" else "F") +
        (if(personality['J']!! >= personality['M']!!) "J" else "M") +
        (if(personality['A']!! >= personality['N']!!) "A" else "N")
}