package com.interview.prep.interviewprep.leetcode.e4_stackqueque.stack.monotonic

import org.junit.Assert.assertEquals
import org.junit.Test

class DailyTemperatureTest {
    // 1. Instantiate the class to test
    private val solution = DailyTemperatures()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val expected: IntArray,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testDailyTemperatures() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(73,74,75,71,69,72,76,73),
                expected = intArrayOf(1,1,4,2,1,1,0,0),
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(30,40,50,60),
                expected = intArrayOf(1,1,1,0),
                message = "Case 2"
            ),
            TestCase(
                input = intArrayOf(30,60,90),
                expected = intArrayOf(1,1,0),
                message = "Case 3"
            ),
            TestCase(
                input = intArrayOf(89,62,70,58,47,47,46,76,100,70),
                expected = intArrayOf(8,1,5,4,3,2,1,1,0,0),
                message = "Case 3"
            ),
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input)
            println(" Test : ${test.input.contentToString()} | result : ${actual.joinToString(",")} | expected : ${test.expected.joinToString(",")}")
            assertEquals("Failed on: ${test.message}",test.expected.joinToString(","), actual.joinToString(","))
        }
    }
}