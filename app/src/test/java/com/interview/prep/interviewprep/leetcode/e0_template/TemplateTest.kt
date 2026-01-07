package com.interview.prep.interviewprep.leetcode.e0_template

import org.junit.Assert.assertEquals
import org.junit.Test

class TemplateTest {
    // 1. Instantiate the class to test
    private val solution = Palindrome()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: String,
        val expected: Boolean,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testTemplate() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = "",
                expected = true,
                message = "Case 1"
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