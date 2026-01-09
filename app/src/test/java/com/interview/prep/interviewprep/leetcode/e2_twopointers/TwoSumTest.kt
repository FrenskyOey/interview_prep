package com.interview.prep.interviewprep.leetcode.e2_twopointers

import org.junit.Assert.assertEquals
import org.junit.Test

class TwoSumTest {
    // 1. Instantiate the class to test
    private val solution = TwoSum()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val target: Int,
        val expected: IntArray,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testTwoSum() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(2,7,11,15),
                target = 9,
                expected = intArrayOf(1,2),
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(2,3,4),
                target = 6,
                expected = intArrayOf(1,3),
                message = "Case 2"
            ),
            TestCase(
                input = intArrayOf(-1,0),
                target = -1,
                expected = intArrayOf(1,2),
                message = "Case 3"
            ),
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input,test.target)
            println(" Test : ${test.input.contentToString()} | result : ${actual.contentToString()} | expected : ${test.expected.contentToString()}")
            assertEquals(
                "Failed on: ${test.message}",
                test.expected.contentToString(),
                actual.contentToString()
            )
        }
    }
}