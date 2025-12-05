import java.math.BigInteger
import kotlin.io.path.Path
import kotlin.io.path.readText

class AOCDay02(val input: String) {

    var ranges: MutableList<MutableList<String>> = mutableListOf()

    init {
        this.ranges = input.split(",")
            .map { range -> range.split("-").toMutableList() }.toMutableList()
    }

    fun findRepeatsInRange(start: String, end: String, repeatSize: Int): List<BigInteger> {
        var repeatedNumbers = mutableListOf<BigInteger>()
        var begin = start
        if (start.length % repeatSize != 0) {
            begin = "1" + "0".repeat(start.length)
            while (begin.length % repeatSize != 0)
                begin += "0"
        }

        val stop = end.toBigInteger()
        var base = begin.take(begin.length / repeatSize)
        var repeatedNumber = base.repeat(repeatSize).toBigInteger()

        if (repeatedNumber < start.toBigInteger()) {
            base = (base.toLong() + 1L).toString()
            repeatedNumber = base.repeat(repeatSize).toBigInteger()
        }

        while (repeatedNumber <= stop ) {
            repeatedNumbers.add(repeatedNumber)
            base = (base.toLong() + 1L).toString()
            repeatedNumber = base.repeat(repeatSize).toBigInteger()
        }

        return repeatedNumbers
    }

    fun calculateSumOfInvalidIds(): BigInteger {
        var sum = BigInteger.ZERO
        for (range in this.ranges) {
            var repeatedNumbers = mutableSetOf<BigInteger>()
            for (repeat in 2..range[1].length) {
                repeatedNumbers.addAll(findRepeatsInRange(range[0], range[1], repeat))
            }
            repeatedNumbers.forEach { number -> sum = sum.add(number) }
        }
        return sum
    }
}

fun main() {
    val fileInput = Path("src/main/resources/inputDay02a.txt").readText()
    val day02 = AOCDay02(fileInput)
    println(day02.calculateSumOfInvalidIds())
}

