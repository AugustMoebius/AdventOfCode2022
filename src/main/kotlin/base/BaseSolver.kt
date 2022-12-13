package base

import java.io.File

abstract class BaseSolver {

    fun readFile(fileName: String): List<String> {
        return File("input/$fileName").useLines { it.toList() }
    }

    abstract fun solve()

}