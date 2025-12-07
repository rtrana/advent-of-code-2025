import kotlin.io.path.Path
import kotlin.io.path.readLines

class AOCDay07(val input: List<String>) {

    var manifold: MutableList<MutableList<Char>> = mutableListOf()
    var splitterLocations: MutableSet<List<Int>> = mutableSetOf()

    init {
        this.manifold = input.map { line -> line.toCharArray().toMutableList() }.toMutableList()
    }

    fun tachyonMove(): Int {
        var tachyonManifold: MutableList<MutableList<Char>> = mutableListOf()
        for (i in this.manifold.indices) {
            tachyonManifold.add(this.manifold[i].toMutableList())
        }

        for (i in tachyonManifold.indices) {
            for (j in tachyonManifold[i].indices) {
                if (tachyonManifold[i][j] == 'S')
                    tachyonManifold[i + 1][j] = '|'
                else if (i > 0 && tachyonManifold[i][j] == '^' && tachyonManifold[i - 1][j] == '|') {
                    this.splitterLocations.add(listOf(i, j))
                    tachyonManifold[i][j - 1] = '|'
                    tachyonManifold[i][j + 1] = '|'
                } else if (i > 0 && (tachyonManifold[i - 1][j] == '|' || tachyonManifold[i - 1][j] == 'S'))
                    tachyonManifold[i][j] = '|'
            }
        }
        return this.splitterLocations.size
    }

    fun findTimelinesFrom(i: Int, j: Int): Long {
        val locationCountStore = mutableMapOf<Pair<Int, Int>, Long>()
        val lastRow = this.manifold.lastIndex

        fun dfs(i: Int, j: Int): Long {
            val key = i to j
            locationCountStore[key]?.let { return it }

            val result: Long =
                if (i == lastRow)
                    1L
                else {
                    val cell = this.manifold[i][j]
                    if (cell == '^') {
                        dfs(i, j - 1) + dfs(i, j + 1)
                    } else {
                        dfs(i + 1, j)
                    }
                }

            locationCountStore[key] = result
            return result
        }
        return dfs(i, j)
    }

    fun findTimelinesFromStartingPosition(): Long {
        var start = mutableListOf<Int>()
        for (i in this.manifold.indices) {
            if (this.manifold[i].toString().contains("S")) {
                start.add(i)
                start.add(this.manifold[i].joinToString("").indexOf('S'))
            }
        }

        return findTimelinesFrom(start[0], start[1])
    }
}

fun main() {
    val fileInput = Path("src/main/resources/inputDay07a.txt").readLines()
    val day07 = AOCDay07(fileInput)
    println(day07.tachyonMove())
    println(day07.findTimelinesFromStartingPosition())
}
