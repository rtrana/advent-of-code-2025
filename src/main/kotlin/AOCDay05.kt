import java.math.BigInteger
import kotlin.collections.mutableListOf
import kotlin.io.path.Path
import kotlin.io.path.readLines

class AOCDay05(val input: List<String>) {

    var ranges = mutableListOf<List<BigInteger>>()
    val ingredients = mutableListOf<BigInteger>()

    init {
        val lines = input.map { it.trim() }.filter { it.isNotEmpty() }

        for (line in lines) {
            if ("-" in line) {
                val (start, end) = line.split("-").map { it.toBigInteger() }
                this.ranges += listOf(start, end)
            } else {
                this.ingredients += line.toBigInteger()
            }
        }
        this.ranges = this.ranges.sortedBy { it.first() }.toMutableList()
    }

    fun countFreshIngredients(): Long {
        var count = 0L
        for (ingredient in this.ingredients) {
            this.ranges.find { ingredient >= it.first() && ingredient <= it[1] }?.let { count++ }
        }
        return count
    }

    fun countPossibleFreshIngredients(): BigInteger {
        val modifiedRanges: MutableList<List<BigInteger>> = mutableListOf()
        this.ranges.forEach { modifiedRanges += it }
        var i = 0
        while (i < modifiedRanges.lastIndex) {
            var currentRange = modifiedRanges[i]
            var nextRange = modifiedRanges[i + 1]
            if (currentRange.last() < nextRange.first())
                i++
            else if (currentRange.last() >= nextRange.last() )
                modifiedRanges.remove(nextRange)
            else if (currentRange.last() < nextRange.last()) {
                modifiedRanges.add(i, listOf(currentRange.first(), nextRange.last()))
                modifiedRanges.remove(currentRange)
                modifiedRanges.remove(nextRange)
            }
        }

        val sum = modifiedRanges.sumOf { it.last() - it.first() + BigInteger.ONE }
        return sum
    }
}

fun main() {
    val fileInput = Path("src/main/resources/inputDay05a.txt").readLines()
    val day05 = AOCDay05(fileInput)
    println(day05.countFreshIngredients())
    println(day05.countPossibleFreshIngredients())
}
