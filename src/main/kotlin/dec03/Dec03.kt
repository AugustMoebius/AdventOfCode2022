package dec03

import base.BaseSolver

class Dec03: BaseSolver() {

    private val alphabet = mutableListOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")

    override fun solve() {
        val lines = readFile("dec03.txt")

        var prioritySum = 0
        for (line in lines) {
            val mid = line.length / 2
            val comp1 = line.substring(0 until mid).toSet()
            val comp2 = line.substring(mid).toSet()
            val intersect = comp1.intersect(comp2)
            prioritySum += getPoints(intersect.first())
        }

        println("sum1: $prioritySum")

        var badgeSum = 0
        val chatSets = lines.map { it.toCharArray().toSet() }.toList()
        val chucks = chatSets.chunked(3)
        for (chunk in chucks) {
            val common = chunk[0].intersect(chunk[1]).intersect(chunk[2]).first()
            badgeSum += getPoints(common)
        }

        println("sum2: $badgeSum")
    }


    private fun getPoints(c : Char): Int {
        val basePoints = alphabet.indexOf(c.lowercase()) + 1
        if (c.isUpperCase()) {
            return basePoints + 26
        }
        return basePoints
    }
}

fun main() {
    Dec03().solve()
}

