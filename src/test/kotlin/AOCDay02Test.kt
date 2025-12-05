import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.math.BigInteger

class AOCDay02Test {

    @Test
    fun `should return repeats in range - case 1`() {
        val day = AOCDay02("")
        assertEquals(listOf("11".toBigInteger(), "22".toBigInteger()),
            day.findRepeatsInRange("11", "22", 2))
    }

    @Test
    fun `should return repeats in range - case 2`() {
        val day = AOCDay02("")
        assertEquals(listOf("99".toBigInteger()), day.findRepeatsInRange("95", "115", 2))
        assertEquals(listOf("111".toBigInteger()), day.findRepeatsInRange("95", "115", 3))
    }

    @Test
    fun `should return repeats in range - case 3`() {
        val day = AOCDay02("")
        assertEquals(listOf("1010".toBigInteger()), day.findRepeatsInRange("998", "1012", 2))
        assertEquals(listOf("999".toBigInteger()), day.findRepeatsInRange("998", "1012", 3))
    }

    @Test
    fun `should return repeats in range - case 4`() {
        val day = AOCDay02("")
        assertEquals(listOf("1188511885".toBigInteger()), day.findRepeatsInRange("1188511880","1188511890", 2))
    }

    @Test
    fun `should return repeats in range - case 5`() {
        val day = AOCDay02("")
        assertEquals(listOf("222222".toBigInteger()), day.findRepeatsInRange("222220", "222224", 2))
    }

    @Test
    fun `should return repeats in range - case 6`() {
        val day = AOCDay02("")
        assertEquals(listOf<BigInteger>(), day.findRepeatsInRange("1698522", "1698528", 2))
    }

    @Test
    fun `should return repeats in range - case 7`() {
        val day = AOCDay02("")
        assertEquals(listOf("446446".toBigInteger()), day.findRepeatsInRange("446443", "446449", 2))
    }

    @Test
    fun `should return repeats in range - case 8`() {
        val day = AOCDay02("")
        assertEquals(listOf("38593859".toBigInteger()), day.findRepeatsInRange("38593856","38593862", 2))
    }

    @Test
    fun `should return repeats in range - case 9`() {
        val day = AOCDay02("")
        assertEquals(listOf<BigInteger>(), day.findRepeatsInRange("565653","565659", 2))
        assertEquals(listOf("565656".toBigInteger()), day.findRepeatsInRange("565653","565659", 3))
    }

    @Test
    fun `should return repeats in range - case 10`() {
        val day = AOCDay02("")
        assertEquals(listOf<BigInteger>(), day.findRepeatsInRange("824824821", "824824827", 2))
        assertEquals(listOf("824824824".toBigInteger()), day.findRepeatsInRange("824824821", "824824827", 3))
    }

    @Test
    fun `should return repeats in range - case 11`() {
        val day = AOCDay02("")
        assertEquals(listOf<BigInteger>(), day.findRepeatsInRange("2121212118","2121212124", 2))
        assertEquals(listOf("2121212121".toBigInteger()), day.findRepeatsInRange("2121212118","2121212124", 5))
    }

    @Test
    fun `should return sum of invalid ids across all ranges`() {
        val day = AOCDay02("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528," +
                "446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124")
        assertEquals("4174379265".toBigInteger(), day.calculateSumOfInvalidIds())
    }
}