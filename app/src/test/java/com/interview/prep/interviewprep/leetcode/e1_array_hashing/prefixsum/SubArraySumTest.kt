package com.interview.prep.interviewprep.leetcode.e1_array_hashing.prefixsum

import org.junit.Assert.assertEquals
import org.junit.Test

class SubArraySumTest {
    // 1. Instantiate the class to test
    private val solution = SubArraySumK()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val total: Int,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testContigousArray() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(1,1,1),
                total = 2,
                expected = 2,
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(1,2,3),
                total = 3,
                expected = 2,
                message = "Case 3"
            ),
            TestCase(
                input = intArrayOf(1, -1, 1, -1),
                total = 0,
                expected = 4,
                message = "Case 3"
            )

        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input,test.total)
            println(" Test : ${test.input.contentToString()} | k : ${test.total} | result : ${actual} | expected : ${test.expected}")
            assertEquals(
                "Failed on: ${test.message}",
                test.expected,
                actual
            )
        }
    }
}