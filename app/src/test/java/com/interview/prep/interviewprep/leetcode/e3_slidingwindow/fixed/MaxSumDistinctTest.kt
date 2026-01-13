package com.interview.prep.interviewprep.leetcode.e3_slidingwindow.fixed

import org.junit.Assert.assertEquals
import org.junit.Test

class MaxSumDistinctTest {
    // 1. Instantiate the class to test
    private val solution = MaxSumDistinct()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        var k : Int,
        val expected: Long,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testMaxSumDistinct() {
        // 3. Define scenarios
        val testCases = listOf(

            TestCase(
                input = intArrayOf(1,5,4,2,9,9,9),
                k = 3,
                expected = 15,
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(4,4,4),
                k = 3,
                expected = 0,
                message = "Case 2"
            ),
            TestCase(
                input = intArrayOf(9,9,9,1,2,3),
                k = 3,
                expected = 12,
                message = "Case 3"
            ),
            TestCase(
                input = intArrayOf(4,3,3,3,2),
                k = 5,
                expected = 0,
                message = "Case 4"
            ),
            TestCase(
                input = intArrayOf(5,3,3,1,1),
                k = 5,
                expected = 0,
                message = "Case 5"
            ),

            )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input, test.k)
            println(" Test : ${test.input.contentToString()} | result : ${actual} | expected : ${test.expected}")
            assertEquals("Failed on: ${test.message}",test.expected, actual)
        }
    }
}