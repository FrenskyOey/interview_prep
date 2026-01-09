package com.interview.prep.interviewprep.leetcode.e2_twopointers

import org.junit.Assert.assertEquals
import org.junit.Test

class WaterContainerTest {
    // 1. Instantiate the class to test
    private val solution = WaterContainer()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testWaterContainer() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(1,8,6,2,5,4,8,3,7),
                expected = 49,
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(1,1),
                expected = 1,
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