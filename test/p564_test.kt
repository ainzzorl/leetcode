package solutions

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class p564_test {
    private var solution: p564 = solutions.p564()

    @Test
    fun odd() {
        assertEquals("121", solution.nearestPalindromic("123"))
        assertEquals("101", solution.nearestPalindromic("103"))
        assertEquals("12321", solution.nearestPalindromic("12312"))
    }

    @Test
    fun even() {
        assertEquals("11", solution.nearestPalindromic("12"))
        assertEquals("22", solution.nearestPalindromic("23"))
        assertEquals("123321", solution.nearestPalindromic("123123"))
        assertEquals("1331", solution.nearestPalindromic("1283"))
    }

    @Test
    fun same() {
        assertEquals("111", solution.nearestPalindromic("121"))
        assertEquals("1111", solution.nearestPalindromic("1221"))
        assertEquals("1001", solution.nearestPalindromic("1111"))
        assertEquals("101", solution.nearestPalindromic("111"))
        assertEquals("111111111", solution.nearestPalindromic("111101111"))
        assertEquals("1111111111", solution.nearestPalindromic("1111001111"))
    }

    @Test
    fun edge() {
        assertEquals("0", solution.nearestPalindromic("1"))
        assertEquals("1", solution.nearestPalindromic("2"))
        assertEquals("9", solution.nearestPalindromic("10"))
        assertEquals("99999", solution.nearestPalindromic("100000"))
        assertEquals("9", solution.nearestPalindromic("10"))
        assertEquals("9", solution.nearestPalindromic("11"))
        assertEquals("101", solution.nearestPalindromic("99"))
        assertEquals("10001", solution.nearestPalindromic("9999"))
    }
}