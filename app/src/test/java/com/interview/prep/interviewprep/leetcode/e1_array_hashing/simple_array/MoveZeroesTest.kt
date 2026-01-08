package com.interview.prep.interviewprep.leetcode.e1_array_hashing.simple_array

import org.junit.Test

class MoveZeroesTest {
    // 1. Instantiate the class to test
    private val solution = MoveZeroes()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val expected: IntArray,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testTemplate() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(0,1,0,3,12),
                expected = intArrayOf(1,3,12,0,0),
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(0),
                expected = intArrayOf(0),
                message = "Case 2"
            ),
            TestCase(
                input = intArrayOf(1),
                expected = intArrayOf(1),
                message = "Case 3"
            )
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input)
            println(" Test : ${test.input.contentToString()} | result : ${actual.contentToString()} | expected : ${test.expected.contentToString()}")
            assert(test.input.contentEquals(test.expected))
        }
    }
}