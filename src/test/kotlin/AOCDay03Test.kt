import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AOCDay03Test {

    @Test
    fun `should return largest joltage - case 1`() {
        val day = AOCDay03(listOf("987654321111111"))
        assertEquals(98, day.findLargestBatteryJoltage(day.batteries[0], 2))
    }

    @Test
    fun `should return largest joltage - case 2`() {
        val day = AOCDay03(listOf("811111111111119"))
        assertEquals(89, day.findLargestBatteryJoltage(day.batteries[0], 2))
    }

    @Test
    fun `should return largest joltage - case 3`() {
        val day = AOCDay03(listOf("234234234234278"))
        assertEquals(78, day.findLargestBatteryJoltage(day.batteries[0], 2))
    }

    @Test
    fun `should return largest joltage - case 4`() {
        val day = AOCDay03(listOf("818181911112111"))
        assertEquals(92, day.findLargestBatteryJoltage(day.batteries[0], 2))
    }

    @Test
    fun `should calculate total joltage`() {
        val day = AOCDay03(listOf(
            "987654321111111",
            "811111111111119",
            "234234234234278",
            "818181911112111"
            )
        )
        assertEquals(357, day.calculateTotalJoltage(2))
    }

    @Test
    fun `should return largest twelve joltage - case 1`() {
        val day = AOCDay03(listOf("987654321111111"))
        assertEquals(987654321111, day.findLargestBatteryJoltage(day.batteries[0], 12))
    }

    @Test
    fun `should return largest twelve joltage - case 2`() {
        val day = AOCDay03(listOf("811111111111119"))
        assertEquals(811111111119, day.findLargestBatteryJoltage(day.batteries[0], 12))
    }

    @Test
    fun `should return largest twelve joltage - case 3`() {
        val day = AOCDay03(listOf("234234234234278"))
        assertEquals(434234234278, day.findLargestBatteryJoltage(day.batteries[0], 12))
    }

    @Test
    fun `should return largest twelve joltage - case 4`() {
        val day = AOCDay03(listOf("818181911112111"))
        assertEquals(888911112111, day.findLargestBatteryJoltage(day.batteries[0], 12))
    }

    @Test
    fun `should calculate total twelve joltage`() {
        val day = AOCDay03(listOf(
            "987654321111111",
            "811111111111119",
            "234234234234278",
            "818181911112111"
        )
        )
        assertEquals(3121910778619, day.calculateTotalJoltage(12))
    }
}