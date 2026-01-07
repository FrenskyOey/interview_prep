package com.interview.prep.interviewprep.leetcode.e0_template

import org.junit.Assert.assertEquals
import org.junit.Test

class PalindromeTest {

    // 1. Instantiate the class to test
    private val solution = Palindrome()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: String,
        val expected: Boolean,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testIsPalindrome() {
        // 3. Define scenarios
        val testCases = listOf(
            // Scenario 1: Standard positive case with punctuation and mixed case
            TestCase(
                input = "A man, a plan, a canal: Panama",
                expected = true,
                message = "Standard complex palindrome"
            ),
            // Scenario 2: Standard negative case
            TestCase(
                input = "race a car",
                expected = false,
                message = "Standard non-palindrome"
            ),
            // Scenario 3: Empty string (or space) is considered palindrome
            TestCase(
                input = " ",
                expected = true,
                message = "Empty/Whitespace string"
            ),
            // Scenario 4: Case sensitivity check simple
            TestCase(
                input = "AbBa",
                expected = true,
                message = "Case sensitivity check"
            ),
            // Scenario 5: Symbols only
            TestCase(
                input = ".,",
                expected = true,
                message = "Symbols only (effectively empty)"
            ),
            // Scenario 6: Numbers
            TestCase(
                input = "12321",
                expected = true,
                message = "Numeric palindrome"
            )
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input)
            println(" Test : ${test.input} | result : ${actual} | expected : ${test.expected}")
            assertEquals(
                "Failed on: ${test.message}",
                test.expected,
                actual
            )
        }
    }
}