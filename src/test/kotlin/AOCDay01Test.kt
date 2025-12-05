import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AOCDay01Test {

    @Test
    fun `should return one for half rotation left`() {
        val day = AOCDay01(listOf("L50"))
        assertEquals(1L, day.rotateAllClicks())
    }

    @Test
    fun `should return one for half rotation right`() {
        val day = AOCDay01(listOf("R50"))
        assertEquals(1L, day.rotateAllClicks())
    }

    @Test
    fun `should return one for full rotation right`() {
        val day = AOCDay01(listOf("R50"))
        assertEquals(1L, day.rotateAllClicks())
    }

    @Test
    fun `should return one for full rotation left`() {
        val day = AOCDay01(listOf("L50"))
        assertEquals(1L, day.rotateAllClicks())
    }

    @Test
    fun `should return zero for not passing or hitting zero going right`() {
        val day = AOCDay01(listOf("R5", "R7"))
        assertEquals(0L, day.rotateAllClicks())
    }

    @Test
    fun `should return zero for not passing or hitting zero going left`() {
        val day = AOCDay01(listOf("L5", "L7"))
        assertEquals(0L, day.rotateAllClicks())
    }

    @Test
    fun `should return one when hitting zero and then going past on the left`() {
        val day = AOCDay01(listOf("L50", "L5"))
        assertEquals(1L, day.rotateAllClicks())
    }

    @Test
    fun `should return one when hitting zero and then going past on the right`() {
        val day = AOCDay01(listOf("R50", "R5"))
        assertEquals(1L, day.rotateAllClicks())
    }

    @Test
    fun `should return six for larger test case`() {
        val day = AOCDay01(listOf(
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82"))
        assertEquals(6L, day.rotateAllClicks())
    }

    @Test
    fun `should return ten for many rotations`() {
        val day = AOCDay01(listOf("R1000"))
        assertEquals(10L, day.rotateAllClicks())
    }

    @Test
    fun `should return zero for going back and forth`() {
        val day = AOCDay01(listOf("L1", "R1", "L1", "R1", "L1", "R1"))
        assertEquals(0L, day.rotateAllClicks())
    }
}