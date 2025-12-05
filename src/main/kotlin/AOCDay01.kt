import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.math.abs

class AOCDay01(val input: List<String>) {

    var directions = listOf<String>()
    var moves = listOf<Long>()

    init {
        this.directions = input.map { it: String -> it.take(1) }
        this.moves = input.map {it: String -> it.substring(1).toLong()}
    }

    fun rotate(): Long {
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
        return count
    }

    fun rotateAllClicks(): Long {
        var currentPosition = 50L
        var prevPosition = 50L
        var circleSize = 100L
        var count = 0L
        for (i in 0..this.directions.lastIndex) {
            val numTicks = this.moves[i]
            val direction = this.directions[i]
            for (i in 1..numTicks) {
                if (direction == "L")
                    currentPosition -= 1
                else
                    currentPosition += 1

                if (currentPosition % 100 == 0L)
                    count++
            }

            if (currentPosition >= 0)
                currentPosition %= circleSize
            else
                currentPosition = circleSize + (currentPosition % circleSize)
        }
        return count
    }
}

fun main() {
    val fileInput = Path("src/main/resources/inputDay01a.txt").readLines()
    val day01 = AOCDay01(fileInput)
    println(day01.rotate())
    println(day01.rotateAllClicks())
}