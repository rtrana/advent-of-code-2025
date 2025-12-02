import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.math.abs
import kotlin.math.floor

class AOCDay01(val input: List<String>) {

    var directions = listOf<String>()
    var moves = listOf<Long>()

    init {
        this.directions = input.map { it: String -> it.take(1) }
        this.moves = input.map {it: String -> it.substring(1).toLong()}
    }

    fun rotate() {
        var position = 50L
        var count = 0L
        for (i in 0..this.directions.lastIndex) {
            if (this.directions[i] == "L")
                position -= this.moves[i]
            else
                position += this.moves[i]

            position %= 100
            if (position < 0) position += 100
            if (position == 0L) count++
        }
        println(count)
    }

    fun rotateAllClicks() {
        var previousPosition = 50L
        var currentPosition = 50L
        var count = 0L
        for (i in 0..this.directions.lastIndex) {
            if (this.directions[i] == "L")
                currentPosition -= this.moves[i]
            else
                currentPosition += this.moves[i]

            if (currentPosition == 0L) count++
            else if (currentPosition < 0 && currentPosition >= -99 && previousPosition > 0) {
                count++
            } else if (currentPosition < -99) {
                count += abs(currentPosition / 100) + 1
            } else {
                count += abs(currentPosition / 100)
            }
            currentPosition %= 100
            if (currentPosition < 0) currentPosition += 100
            previousPosition = currentPosition
        }
        println(count)
    }
}

fun main() {
    val fileInput = Path("src/main/resources/inputDay01b.txt").readLines()
    val day01 = AOCDay01(fileInput)
    day01.rotate()
    day01.rotateAllClicks()
}