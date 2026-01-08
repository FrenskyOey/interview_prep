package com.interview.prep.interviewprep.leetcode.e1_array_hashing.prefixsum

import org.junit.Assert.assertEquals
import org.junit.Test

class ProductExcludeTest {
    // 1. Instantiate the class to test
    private val solution = ProductExclude()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val expected: IntArray,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testProductExclude() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(1,2,3,4),
                expected = intArrayOf(24,12,8,6),
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(-1,1,0,-3,3),
                expected = intArrayOf(0,0,9,0,0),
                message = "Case 2"
            )
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input)
            println(" Test : ${test.input.contentToString()} | result : ${actual.contentToString()} | expected : ${test.expected.contentToString()}")
            assertEquals(
                "Failed on: ${test.message}",
                test.expected.contentToString(),
                actual.contentToString()
            )
        }
    }
}