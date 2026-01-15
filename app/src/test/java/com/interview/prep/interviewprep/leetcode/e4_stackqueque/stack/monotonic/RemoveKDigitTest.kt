package com.interview.prep.interviewprep.leetcode.e4_stackqueque.stack.monotonic

import org.junit.Assert.assertEquals
import org.junit.Test

class RemoveKDigitTest {
    // 1. Instantiate the class to test
    private val solution = RemoveKDigits()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: String,
        val k: Int,
        val expected: String,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testRemoveKDigit() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = "1432219",
                k=3,
                expected = "1219",
                message = "Case 1"
            ),
            TestCase(
                input = "10200",
                k=1,
                expected = "200",
                message = "Case 2"
            ),
            TestCase(
                input = "10",
                k=2,
                expected = "0",
                message = "Case 3"
            ),
            TestCase(
                input = "112",
                k=1,
                expected = "11",
                message = "Case 4"
            )
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input,test.k)
            println(" Test : ${test.input} | result : ${actual} | expected : ${test.expected}")
            assertEquals("Failed on: ${test.message}",test.expected, actual)
        }
    }
}