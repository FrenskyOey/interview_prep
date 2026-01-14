package com.interview.prep.interviewprep.leetcode.e4_stackqueque.stack.monotonic

import org.junit.Assert.assertEquals
import org.junit.Test

class LargestRectangleTest {

    // 1. Instantiate the class to test
    private val solution = LargestRectangle()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testDailyTemperatures() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(2,1,5,6,2,3),
                expected = 10,
                message = "Case 1"
            ),
            /*TestCase(
                input = intArrayOf(2,4),
                expected = 4,
                message = "Case 2"
            ),*/
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input)
            println(" Test : ${test.input.contentToString()} | result : ${actual} | expected : ${test.expected}")
            assertEquals("Failed on: ${test.message}",test.expected, actual)
        }
    }
}