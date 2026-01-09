package com.interview.prep.interviewprep.leetcode.e1_array_hashing.hashmap

import org.junit.Assert.assertEquals
import org.junit.Test

class LongestConsquetiveTest {

    // 1. Instantiate the class to test
    private val solution = LongestConsquetive()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testLongestConsquetive() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(100,4,200,1,3,2),
                expected = 4,
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(0,3,7,2,5,8,4,6,0,1),
                expected = 9,
                message = "Case 2"
            ),
            TestCase(
                input = intArrayOf(1,0,1,2),
                expected = 3,
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