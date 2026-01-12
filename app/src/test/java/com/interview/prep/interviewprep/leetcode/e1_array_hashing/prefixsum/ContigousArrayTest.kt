package com.interview.prep.interviewprep.leetcode.e1_array_hashing.prefixsum

import org.junit.Assert.assertEquals
import org.junit.Test

class ContigousArrayTest {
    // 1. Instantiate the class to test
    private val solution = ContigousArray()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testContigousArray() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(0,1),
                expected = 2,
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(0,1,0),
                expected = 2,
                message = "Case 2"
            ),
            TestCase(
                input = intArrayOf(0,1,1,1,1,1,0,0,0),
                expected = 6,
                message = "Case 3"
            )
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