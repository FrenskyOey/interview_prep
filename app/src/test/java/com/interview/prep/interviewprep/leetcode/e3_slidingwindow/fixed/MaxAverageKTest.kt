package com.interview.prep.interviewprep.leetcode.e3_slidingwindow.fixed

import org.junit.Assert.assertEquals
import org.junit.Test

class MaxAverageKTest {
    // 1. Instantiate the class to test
    private val solution = MaxAverageK()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        var k : Int,
        val expected: Double,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testTemplate() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(1,12,-5,-6,50,3),
                k = 4,
                expected = 12.75,
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(5),
                k = 1,
                expected = 5.0,
                message = "Case 2"
            ),

        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input, test.k)
            println(" Test : ${test.input.contentToString()} | result : ${actual} | expected : ${test.expected}")
            assertEquals("Failed on: ${test.message}",test.expected, actual, 0.000001)
        }
    }
}