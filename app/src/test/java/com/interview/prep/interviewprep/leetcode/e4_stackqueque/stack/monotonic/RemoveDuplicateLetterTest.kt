package com.interview.prep.interviewprep.leetcode.e4_stackqueque.stack.monotonic

import org.junit.Assert.assertEquals
import org.junit.Test

class RemoveDuplicateLetterTest {
    // 1. Instantiate the class to test
    private val solution = RemoveDuplicateLetter()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: String,
        val expected: String,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testValidParantheses() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = "bcabc",
                expected = "abc",
                message = "Case 1"
            ),
            TestCase(
                input = "cbacdcbc",
                expected = "acdb",
                message = "Case 2"
            ),
            TestCase(
                input = "bddbccd",
                expected = "bcd",
                message = "Case 3"
            ),
            TestCase(
                input = "acbac",
                expected = "abc",
                message = "Case 4"
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