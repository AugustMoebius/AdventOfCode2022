package dec02

import base.BaseSolver
import dec01.Dec01

class Dec02: BaseSolver() {

    override fun solve() {
        val lines = readFile("dec02.txt");

        val win = 6
        val draw = 3
        val loss = 0

        val rock = 1
        val paper = 2
        val scissors = 3

        val rockList = listOf("A", "X") // 1 point
        val paperList = listOf("B", "Y") // 2 point
        val scissorsList = listOf("C", "Z") // 3 point

        var score = 0;
        for (line in lines) {
            val split = line.split(" ")
            val opponentMove = split[0]
            val myMove = split[1]

            if (opponentMove in rockList) {
                when (myMove) {
                    in rockList -> {
                        score += draw + rock
                    }
                    in paperList -> {
                        score += win + paper
                    }
                    in scissorsList -> {
                        score += loss + scissors
                    }
                }
            }

            if (opponentMove in paperList) {
                when (myMove) {
                    in rockList -> {
                        score += loss + rock
                    }
                    in paperList -> {
                        score += draw + paper
                    }
                    in scissorsList -> {
                        score += win + scissors
                    }
                }
            }

            if (opponentMove in scissorsList) {
                when (myMove) {
                    in rockList -> {
                        score += win + rock
                    }
                    in paperList -> {
                        score += loss + paper
                    }
                    in scissorsList -> {
                        score += draw + scissors
                    }
                }
            }
        }
        println("part1: $score")
        solve2()
    }


    fun solve2() {
        val lines = readFile("dec02.txt");

        val winPoint = 6
        val drawPoint = 3
        val lossPoint = 0

        val rockPoint = 1
        val paperPoint = 2
        val scissorsPoint = 3

        val rock = "A"
        val paper = "B"
        val scissors = "C"

        val lose = "X"
        val draw = "Y"
        val win = "Z"

        var score = 0;
        for (line in lines) {
            val split = line.split(" ")
            val opponentMove = split[0]
            val myMove = split[1]

            if (opponentMove == rock) {
                when (myMove) {
                    win -> {
                        score += winPoint + paperPoint
                    }
                    draw -> {
                        score += drawPoint + rockPoint
                    }
                    lose -> {
                        score += lossPoint + scissorsPoint
                    }
                }
            }

            if (opponentMove == paper) {
                when (myMove) {
                    win -> {
                        score += winPoint + scissorsPoint
                    }
                    draw -> {
                        score += drawPoint + paperPoint
                    }
                    lose -> {
                        score += lossPoint + rockPoint
                    }
                }
            }

            if (opponentMove == scissors) {
                when (myMove) {
                    win -> {
                        score += winPoint + rockPoint
                    }
                    draw -> {
                        score += drawPoint + scissorsPoint
                    }
                    lose -> {
                        score += lossPoint + paperPoint
                    }
                }
            }
        }
        println("part2: $score")
    }
}

fun main() {
    Dec02().solve();
}