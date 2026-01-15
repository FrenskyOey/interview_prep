package com.interview.prep.interviewprep.leetcode.e4_stackqueque.queque.monotonic

import org.junit.Assert.assertEquals
import org.junit.Test

class SlidingWindowMaximumTest {
    // 1. Instantiate the class to test
    private val solution = SlidingWindowMaximum()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val k : Int,
        val expected: IntArray,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testSlidingWindowMaximum() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(1,3,-1,-3,5,3,6,7),
                k=3,
                expected = intArrayOf(3,3,5,5,6,7),
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(1),
                k=1,
                expected = intArrayOf(1),
                message = "Case 2"
            ),
            TestCase(
                input = intArrayOf(1,3,1,2,0,5),
                k=3,
                expected = intArrayOf(3,3,2,5),
                message = "Case 3"
            ),
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input,test.k)
            println(" Test : ${test.input.contentToString()} | result : ${actual.joinToString(",")} | expected : ${test.expected.joinToString(",")}")
            assertEquals("Failed on: ${test.message}",test.expected.joinToString(","), actual.joinToString(","))
        }
    }
}