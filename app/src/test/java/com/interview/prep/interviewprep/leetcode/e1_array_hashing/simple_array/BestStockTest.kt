package com.interview.prep.interviewprep.leetcode.e1_array_hashing.simple_array

import com.interview.prep.interviewprep.leetcode.e0_template.Palindrome
import org.junit.Assert.assertEquals
import org.junit.Test

class BestStockTest {
    // 1. Instantiate the class to test
    private val solution = BestStock2()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testTemplate() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(7,1,5,3,6,4),
                expected = 7,
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(1,2,3,4,5),
                expected = 4,
                message = "Case 2"
            ),
            TestCase(
                input = intArrayOf(7,6,4,3,1),
                expected = 0,
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