import java.math.BigInteger
import kotlin.io.path.Path
import kotlin.io.path.readLines

class AOCDay03(val input: List<String>) {

    var batteries: MutableList<MutableList<Int>> = mutableListOf()

    init {
        input.forEach {
            this.batteries.add(it.map { battery -> battery.toString().toInt() }.toMutableList())
        }
    }

    fun findLargestBatteryJoltage(battery: List<Int>, joltageSize: Int): Long {
        var start = 0
        val joltage = mutableListOf<Int>()
        var remaining = joltageSize
        while (remaining > 0) {
            val largest = battery.subList(start, battery.size).dropLast(remaining - 1).max()
            joltage.add(largest)
            start += battery.subList(start, battery.size).dropLast(remaining - 1).indexOf(largest) + 1
            remaining--
        }

        val largestJoltage = joltage.joinToString(separator = "").toLong()
        return largestJoltage
    }

    fun calculateTotalJoltage(joltageSize: Int): Long {
        var totalJoltage = 0L
        for (battery in batteries) {
            totalJoltage += findLargestBatteryJoltage(battery, joltageSize)
        }
        return totalJoltage
    }
}

fun main() {
    val fileInput = Path("src/main/resources/inputDay03a.txt").readLines()
    val day03 = AOCDay03(fileInput)
    println(day03.calculateTotalJoltage(2))
    println(day03.calculateTotalJoltage(12))
}
