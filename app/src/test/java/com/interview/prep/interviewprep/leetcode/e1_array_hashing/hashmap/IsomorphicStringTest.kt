package com.interview.prep.interviewprep.leetcode.e1_array_hashing.hashmap

import com.interview.prep.interviewprep.leetcode.e0_template.Palindrome
import org.junit.Assert.assertEquals
import org.junit.Test

class IsomorphicStringTest {
    // 1. Instantiate the class to test
    private val solution = IsomorphicStrings()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: String,
        val input2: String,
        val expected: Boolean,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testIsomorphicString() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = "bbbaaaba",
                input2 = "aaabbbba",
                expected = false,
                message = "Case 4"
            ),
            /*
            TestCase(
                input = "egg",
                input2 = "add",
                expected = true,
                message = "Case 1"
            ),
            TestCase(
                input = "foo",
                input2 = "bar",
                expected = false,
                message = "Case 2"
            ),
            TestCase(
                input = "paper",
                input2 = "title",
                expected = true,
                message = "Case 3"
            )*/
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(s = test.input,t = test.input2)

            println(" Test : ${test.input} , ${test.input2}   |  result : ${actual} | expected : ${test.expected}")
            assertEquals(
                "Failed on: ${test.message}",
                test.expected,
                actual
            )
        }
    }
}