package com.interview.prep.interviewprep.leetcode.e4_stackqueque.stack.standard

import org.junit.Assert.assertEquals
import org.junit.Test

class ValidParanthesesTest {
    // 1. Instantiate the class to test
    private val solution = ValidParentheses()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: String,
        val expected: Boolean,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testValidParantheses() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = "()",
                expected = true,
                message = "Case 1"
            ),
            TestCase(
                input = "()[]{}",
                expected = true,
                message = "Case 2"
            ),
            TestCase(
                input = "(]",
                expected = false,
                message = "Case 3"
            ),
            TestCase(
                input = "([])",
                expected = true,
                message = "Case 4"
            ),
            TestCase(
                input = "([)]",
                expected = false,
                message = "Case 5"
            ),

            )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input)
            println(" Test : ${test.input} | result : ${actual} | expected : ${test.expected}")
            assertEquals("Failed on: ${test.message}",test.expected, actual)
        }
    }
}