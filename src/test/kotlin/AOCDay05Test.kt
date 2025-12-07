import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AOCDay05Test {

    @Test
    fun `should return 14 possible ingredients`() {
        val day = AOCDay05(listOf(
            "3-5",
            "10-14",
            "16-20",
            "12-18",
            "\n",
            "1"
        ))
        assertEquals(14.toBigInteger(), day.countPossibleFreshIngredients())
    }

    @Test
    fun `should return 24 possible ingredients`() {
        val day = AOCDay05(listOf(
            "3-5",
            "10-14",
            "12-30",
            "16-20",
            "\n",
            "1"
        ))
        assertEquals(24.toBigInteger(), day.countPossibleFreshIngredients())
    }

    @Test
    fun `should return 10 possible ingredients`() {
        val day = AOCDay05(listOf(
            "3-5",
            "5-7",
            "7-9",
            "11-13",
            "\n",
            "1"
        ))
        assertEquals(10.toBigInteger(), day.countPossibleFreshIngredients())
    }

    @Test
    fun `should return 51 possible ingredients`() {
        val day = AOCDay05(listOf(
            "3-50",
            "5-7",
            "12-15",
            "49-53",
            "\n",
            "1"
        ))
        assertEquals(51.toBigInteger(), day.countPossibleFreshIngredients())
    }

    @Test
    fun `should return many possible ingredients`() {
        val day = AOCDay05(listOf(
            "112873707283-2588072976190",
            "1752048538382-3919577713656",
            "3279007340166-5487289120805",
            "4916521308175-6760678504079",
            "\n",
            "1"
        ))
        assertEquals("6647804796797".toBigInteger(), day.countPossibleFreshIngredients())
    }

}