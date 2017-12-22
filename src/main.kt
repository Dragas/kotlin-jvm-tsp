import kotlin.io.*
import kotlin.system.measureTimeMillis

fun addNeighbors(line: String, graph: Graph, lineNumber: Int): Node {
    val node = graph[lineNumber]
    line.split(',').forEachIndexed { index, value ->
        node.neighbors.put(graph[index], value.trim().toInt())//.trim().toInt())
    }
    return node
}

fun main(args: Array<String>) {
    /*if (args.size != 2) {
        println("usage: tsp <input file> <output file>")
        return
    }*/

    val result = measureTimeMillis {
        val graph = parseFile("tsp_exp.txt")
        Greedy(graph).solve()
    }
    println("Took $result ms")
}