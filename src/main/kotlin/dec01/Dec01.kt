package dec01

import base.BaseSolver

class Dec01: BaseSolver() {


    override fun solve() {
        val lines = readFile("dec01.txt");

        var sum = 0
        val kcalList = mutableListOf<Int>()
        for(line in lines) {
           if (line.isBlank()) {
               kcalList.add(sum)
               sum = 0
               continue
           }
            sum += line.toInt()
        }
        kcalList.sort()
        kcalList.reverse()
        println("Top: " + kcalList.maxOrNull())
        println("Sum: " + kcalList.subList(0,3).sum())
    }

}

fun main(args: Array<String>) {
    Dec01().solve();
}