package com.interview.prep.interviewprep.leetcode.e3_slidingwindow.dynamic

import org.junit.Assert.assertEquals
import org.junit.Test

class MinWindowSubTest {
    // 1. Instantiate the class to test
    private val solution = MinWindowSub()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: String,
        val target: String,
        val expected: String,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testMinWindowSubTest() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase("ADOBECODEBANC", "ABC", "BANC","Case 1"),
            TestCase("a", "a", "a","Case 2"),
            TestCase("ab", "b", "b","Case 3"),
            TestCase("a", "aa", "","Case 4"),
            )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input,test.target)
            println(" Test : ${test.input} | ${test.target} | result : ${actual} | expected : ${test.expected}")
            assertEquals(
                "Failed on: ${test.message}",
                test.expected,
                actual
            )
        }
    }
}