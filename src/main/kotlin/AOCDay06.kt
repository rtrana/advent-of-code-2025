import java.math.BigInteger
import kotlin.collections.mutableListOf
import kotlin.io.path.Path
import kotlin.io.path.readLines

class AOCDay06(val input: List<String>) {

    var columnsNoPadding: MutableList<List<BigInteger>> = mutableListOf()
    var operations: MutableList<String> = mutableListOf()
    var columnsWithPadding: MutableList<List<BigInteger>> = mutableListOf()

    init {
        getColumnsAndOperationsFromInput()
        getColumnsWithPadding()
    }

    fun getColumnsWithPadding() {
        var inputNoOps = input.subList(0, input.lastIndex)
        var columnOfNumbers = mutableListOf<BigInteger>()
        for (j in 0..inputNoOps[0].lastIndex) {
            var number = ""
            for (i in 0..inputNoOps.lastIndex) {
                number += inputNoOps[i][j]
            }

            if (number.contains(Regex("[0-9]")))
                columnOfNumbers.add(number.trim().toBigInteger())
            else {
                this.columnsWithPadding.add(columnOfNumbers)
                columnOfNumbers = mutableListOf()
            }

            if (j == inputNoOps[0].lastIndex) {
                this.columnsWithPadding.add(columnOfNumbers)
            }
        }
    }

    fun getColumnsAndOperationsFromInput() {
        var lines = input.map { line -> line.trim().split(Regex("[ ]+")) }
        for (j in 0..lines[0].lastIndex) {
            var column: MutableList<BigInteger> = mutableListOf()
            for (i in 0..< lines.lastIndex) {
                column.add(lines[i][j].toBigInteger())
            }
            this.operations.add(lines[lines.lastIndex][j])
            this.columnsNoPadding.add(column)
        }
    }

    fun totalSumOfColumns(opGrouping: List<List<BigInteger>>): BigInteger {
        val sums: MutableList<BigInteger> = mutableListOf()
        for (i in 0..this.operations.lastIndex) {
            if (this.operations[i] == "+") {
                sums.add(opGrouping[i].fold(BigInteger.ZERO) { acc, n -> acc + n })
            } else {
                sums.add(opGrouping[i].fold(BigInteger.ONE) { acc, n -> acc * n })
            }
        }
        return sums.fold(BigInteger.ZERO) { acc, n -> acc + n }
    }

    fun sumColumnsNoPadding(): BigInteger{
        return totalSumOfColumns(this.columnsNoPadding)
    }

    fun sumColumnsWithPadding(): BigInteger {
        return totalSumOfColumns(this.columnsWithPadding)
    }
}

fun main() {
    val fileInput = Path("src/main/resources/inputDay06a.txt").readLines()
    val day06 = AOCDay06(fileInput)
    println(day06.sumColumnsNoPadding())
    println(day06.sumColumnsWithPadding())
}
