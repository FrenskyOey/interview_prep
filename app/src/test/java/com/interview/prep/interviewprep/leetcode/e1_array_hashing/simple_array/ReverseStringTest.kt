package com.interview.prep.interviewprep.leetcode.e1_array_hashing.simple_array

import org.junit.Assert.assertEquals
import org.junit.Test

class ReverseStringTest {
    // 1. Instantiate the class to test
    private val solution = ReverseString()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: String,
        val expected: String,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testReverseString() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = "the sky is blue",
                expected = "blue is sky the",
                message = "Case 1"
            ),
            TestCase(
                input = "  hello world  ",
                expected = "world hello",
                message = "Case 2"
            ),
            TestCase(
                input = "a good   example",
                expected = "example good a",
                message = "Case 3"
            ),
            TestCase(
                input = "NonSpace",
                expected = "NonSpace",
                message = "Case 4"
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