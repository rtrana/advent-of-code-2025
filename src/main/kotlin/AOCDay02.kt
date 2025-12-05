import java.math.BigInteger
import kotlin.io.path.Path
import kotlin.io.path.readText

class AOCDay02(val input: String) {

    var ranges: MutableList<MutableList<String>> = mutableListOf()

    init {
        this.ranges = input.split(",")
            .map { range -> range.split("-").toMutableList() }.toMutableList()
    }

    fun sumRepeatsInRange(start: String, end: String): BigInteger {
        var sum = BigInteger.ZERO
        var begin = start
        if (start.length % 2 != 0)
            begin = "1" + "0".repeat(start.length)

        val stop = end.toBigInteger()
        var base = begin.take(begin.length / 2)
        var repeatedNumber = base.repeat(2).toBigInteger()

        if (repeatedNumber < begin.toBigInteger()) {
            base = (base.toLong() + 1L).toString()
            repeatedNumber = base.repeat(2).toBigInteger()
        }

        while (repeatedNumber <= stop ) {
            sum = sum.add(repeatedNumber)
            base = (base.toLong() + 1L).toString()
            repeatedNumber = base.repeat(2).toBigInteger()
        }

        return sum
    }

    fun calculateSumOfInvalidIds(): BigInteger {
        var sum = BigInteger.ZERO
        this.ranges.forEach {
            sum = sum.add(sumRepeatsInRange(it[0], it[1]))
        }
        return sum
    }
}

fun main() {
    val fileInput = Path("src/main/resources/inputDay02a.txt").readText()
    val day02 = AOCDay02(fileInput)
    println(day02.calculateSumOfInvalidIds())
}