package com.interview.prep.interviewprep.leetcode.e3_slidingwindow.dynamic

import org.junit.Assert.assertEquals
import org.junit.Test

class MaxConsecuitveOneTest {
    // 1. Instantiate the class to test
    private val solution = MaxConsecutiveOne()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val k: Int,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testMaxConsecutive() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(intArrayOf(1,1,1,0,0,0,1,1,1,1,0), 2,6, "Case 1"),
            TestCase(intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1), 3,10, "Case 2"),
            TestCase(intArrayOf(0,0,1,1,1,0,0), 0,3, "Case 3"),
            TestCase(intArrayOf(1,1,1,0,0,0,1,1,1,1), 0,4, "Case 4"),
            )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input, test.k)
            println(" Test : ${test.input.contentToString()} | result : ${actual} | expected : ${test.expected}")
            assertEquals(
                "Failed on: ${test.message}",
                test.expected,
                actual
            )
        }
    }
}
