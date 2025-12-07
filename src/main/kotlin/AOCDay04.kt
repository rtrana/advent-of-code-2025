import kotlin.io.path.Path
import kotlin.io.path.readLines

class AOCDay04(val input: List<String>) {

    var locations: Array<Array<Char>> = Array(input.size) { Array(input[0].length) { '.' } }
    var accessibleLocations: MutableList<List<Int>> = mutableListOf()

    init {
        for (i in input.indices) {
            for (j in input[0].indices) {
                this.locations[i][j] = input[i][j]
            }
        }
    }

    fun unblockedAccessPoints(): Int {
        var unblocked = 0
        do {
            unblocked += countAccessPoints()
            for (coordinate in this.accessibleLocations) {
                this.locations[coordinate[0]][coordinate[1]] = '.'
            }
        } while (this.accessibleLocations.isNotEmpty())
        return unblocked
    }

    fun countAccessPoints(): Int {
        var count = 0
        this.accessibleLocations = mutableListOf()
        for (i in this.locations.indices) {
            for (j in this.locations[0].indices) {
                count += calculateCountForLocation(i, j)
            }
        }
        return count
    }

    fun calculateCountForLocation(i: Int, j: Int): Int {
        var count = 0
        if (isCorner(i, j)) {
            if (this.locations[i][j] == '@') {
                count++
                this.accessibleLocations.add(listOf(i, j))
            }
        } else if (i == 0)
            count += isAccessible(i, j, listOf(
                this.locations[i][j-1], this.locations[i][j+1],
                this.locations[i+1][j-1], this.locations[i+1][j], this.locations[i+1][j+1]))
        else if (i == this.locations.lastIndex)
            count += isAccessible(i, j, listOf(
                this.locations[i][j-1], this.locations[i][j+1],
                this.locations[i-1][j-1], this.locations[i-1][j], this.locations[i-1][j+1]))
        else if (j == 0)
            count += isAccessible(i, j, listOf(
                this.locations[i-1][j], this.locations[i+1][j],
                this.locations[i-1][j+1], this.locations[i][j+1], this.locations[i+1][j+1]))
        else if (j == this.locations[0].lastIndex)
            count += isAccessible(i, j, listOf(
                this.locations[i-1][j], this.locations[i+1][j],
                this.locations[i-1][j-1], this.locations[i][j-1], this.locations[i+1][j-1]))
        else
            count += isAccessible(i, j, listOf(
                this.locations[i-1][j-1], this.locations[i-1][j], this.locations[i-1][j+1],
                this.locations[i][j-1], this.locations[i][j+1],
                this.locations[i+1][j-1], this.locations[i+1][j], this.locations[i+1][j+1]))
        return count
    }

    fun isAccessible(i: Int, j: Int, neighbors: List<Char>): Int {
        if (this.locations[i][j] == '.') return 0
        val accessCount = neighbors.count { it == '@' }.let { if (it < 4) 1 else 0 }
        if (accessCount == 1)
            this.accessibleLocations.add(listOf(i, j))
        return accessCount
    }

    fun isCorner(i: Int, j: Int): Boolean {
        if (i == 0 && j == 0)
            return true
        if (i == 0 && j == this.locations[0].lastIndex)
            return true
        if (i == this.locations.lastIndex && j == 0)
            return true
        if (i == this.locations.lastIndex && j == this.locations[0].lastIndex)
            return true
        return false
    }

}

fun main() {
    val fileInput = Path("src/main/resources/inputDay04a.txt").readLines()
    val day04 = AOCDay04(fileInput)
    println(day04.countAccessPoints())
    println(day04.unblockedAccessPoints())
}
