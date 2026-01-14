package com.interview.prep.interviewprep.leetcode.e4_stackqueque.stack.standard

import org.junit.Assert.assertEquals
import org.junit.Test

class LongestValidParanthesesTest {
    // 1. Instantiate the class to test
    private val solution = LongestValidParantheses()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: String,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testTemplate() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = "(()",
                expected = 2,
                message = "Case 1"
            ),
            TestCase(
                input = ")()())",
                expected = 4,
                message = "Case 2"
            ),
            TestCase(
                input = "",
                expected = 0,
                message = "Case 3"
            )
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input)
            println(" Test : ${test.input} | result : ${actual} | expected : ${test.expected}")
            assertEquals(
                "Failed on: ${test.message}",
                test.expected,
                actual
            )
        }
    }
}