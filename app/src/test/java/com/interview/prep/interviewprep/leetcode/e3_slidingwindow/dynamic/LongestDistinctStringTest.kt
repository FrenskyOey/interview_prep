package com.interview.prep.interviewprep.leetcode.e3_slidingwindow.dynamic

import org.junit.Assert.assertEquals
import org.junit.Test

class LongestDistinctStringTest {
    // 1. Instantiate the class to test
    private val solution = LongestDistinctString()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: String,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testCountSubstringChar() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase("abcabcbb", 3, "Case 1"),
            TestCase("bbbbb", 1, "Case 2"),
            TestCase("pwwkew", 3, "Case 3"),

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