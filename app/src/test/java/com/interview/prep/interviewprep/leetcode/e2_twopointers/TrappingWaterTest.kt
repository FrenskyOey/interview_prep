package com.interview.prep.interviewprep.leetcode.e2_twopointers

import org.junit.Assert.assertEquals
import org.junit.Test

class TrappingWaterTest {
    // 1. Instantiate the class to test
    private val solution = TrappingRainWater()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testTrapingWater() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1),
                expected = 6,
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(4,2,0,3,2,5),
                expected = 9,
                message = "Case 2"
            ),
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input)
            println(" Test : ${test.input.contentToString()} | result : ${actual} | expected : ${test.expected}")
            assertEquals(
                "Failed on: ${test.message}",
                test.expected,
                actual
            )
        }
    }
}