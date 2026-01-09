package com.interview.prep.interviewprep.leetcode.e1_array_hashing.hashmap

import com.interview.prep.interviewprep.leetcode.e0_template.Palindrome
import org.junit.Assert.assertEquals
import org.junit.Test

class GroupAnagramTest {
    // 1. Instantiate the class to test
    private val solution = GroupAnagrams()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: Array<String>,
        val expected: List<List<String>>,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testTemplate() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = arrayOf("eat","tea","tan","ate","nat","bat"),
                expected = arrayListOf(arrayListOf("bat"),arrayListOf("nat","tan"),arrayListOf("ate","eat","tea")),
                message = "Case 1"
            ),
            TestCase(
                input = arrayOf(""),
                expected = arrayListOf(arrayListOf("")),
                message = "Case 2"
            ),
            TestCase(
                input = arrayOf("a"),
                expected = arrayListOf(arrayListOf("a")),
                message = "Case 3"
            ),
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input)

            // Sort both for comparison to avoid order-dependency issues
            val sortedActual = actual.map { it.sorted() }.sortedBy { it.firstOrNull() }
            val sortedExpected = test.expected.map { it.sorted() }.sortedBy { it.firstOrNull() }

            // Formatting the output for readability
            val actualStr = sortedActual.joinToString(separator = ", ", prefix = "[", postfix = "]")
            val expectedStr = sortedExpected.joinToString(separator = ", ", prefix = "[", postfix = "]")

            println("Test: ${test.input.contentToString()}")
            println("  -> Actual:   $actualStr")
            println("  -> Expected: $expectedStr")
            println("--------------------------------------------------")


            assertEquals(
                "Failed on: ${test.message}",
                sortedExpected,
                sortedActual
            )
        }
    }
}