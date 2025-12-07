import kotlin.io.path.Path
import kotlin.io.path.readLines

class AOCDay07(val input: List<String>) {

    var manifold: MutableList<MutableList<Char>> = mutableListOf()
    var splitterLocations: MutableSet<List<Int>> = mutableSetOf()

    init {
        this.manifold = input.map { line -> line.toCharArray().toMutableList() }.toMutableList()
    }

    fun tachyonMove(): Int {
        for (i in this.manifold.indices) {
            for (j in this.manifold[i].indices) {
                if (this.manifold[i][j] == 'S')
                    this.manifold[i + 1][j] = '|'
                else if (i > 0 && this.manifold[i][j] == '^' && this.manifold[i - 1][j] == '|') {
                    this.splitterLocations.add(listOf(i, j))
                    this.manifold[i][j - 1] = '|'
                    this.manifold[i][j + 1] = '|'
                } else if (i > 0 && (this.manifold[i - 1][j] == '|' || this.manifold[i - 1][j] == 'S'))
                    this.manifold[i][j] = '|'
            }
        }
        return this.splitterLocations.size
    }
}

fun main() {
    val fileInput = Path("src/main/resources/inputDay07a.txt").readLines()
    val day07 = AOCDay07(fileInput)
    println(day07.tachyonMove())
}
