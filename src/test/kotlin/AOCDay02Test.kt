import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.math.BigInteger

class AOCDay02Test {

    @Test
    fun `should return sum of repeats in range - case 1`() {
        val day = AOCDay02("")
        assertEquals("33".toBigInteger(), day.sumRepeatsInRange("11", "22"))
    }

    @Test
    fun `should return sum of repeats in range - case 2`() {
        val day = AOCDay02("")
        assertEquals("99".toBigInteger(), day.sumRepeatsInRange("95", "115"))
    }

    @Test
    fun `should return sum of repeats in range - case 3`() {
        val day = AOCDay02("")
        assertEquals("1010".toBigInteger(), day.sumRepeatsInRange("998", "1012"))
    }

    @Test
    fun `should return sum of repeats in range - case 4`() {
        val day = AOCDay02("")
        assertEquals("1188511885".toBigInteger(), day.sumRepeatsInRange("1188511880","1188511890"))
    }

    @Test
    fun `should return sum of repeats in range - case 5`() {
        val day = AOCDay02("")
        assertEquals("222222".toBigInteger(), day.sumRepeatsInRange("222220", "222224"))
    }

    @Test
    fun `should return sum of repeats in range - case 6`() {
        val day = AOCDay02("")
        assertEquals(BigInteger.ZERO, day.sumRepeatsInRange("1698522", "1698528"))
    }

    @Test
    fun `should return sum of repeats in range - case 7`() {
        val day = AOCDay02("")
        assertEquals("446446".toBigInteger(), day.sumRepeatsInRange("446443", "446449"))
    }

    @Test
    fun `should return sum of repeats in range - case 8`() {
        val day = AOCDay02("")
        assertEquals("38593859".toBigInteger(), day.sumRepeatsInRange("38593856","38593862"))
    }

    @Test
    fun `should return sum of repeats in range - case 9`() {
        val day = AOCDay02("")
        assertEquals(BigInteger.ZERO, day.sumRepeatsInRange("565653","565659"))
    }

    @Test
    fun `should return sum of repeats in range - case 10`() {
        val day = AOCDay02("")
        assertEquals(BigInteger.ZERO, day.sumRepeatsInRange("824824821", "824824827"))
    }

    @Test
    fun `should return sum of repeats in range - case 11`() {
        val day = AOCDay02("")
        assertEquals(BigInteger.ZERO, day.sumRepeatsInRange("2121212118","2121212124"))
    }

    @Test
    fun `should return sum of invalid ids across all ranges`() {
        val day = AOCDay02("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528," +
                "446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124")
        assertEquals("1227775554".toBigInteger(), day.calculateSumOfInvalidIds())
    }
}