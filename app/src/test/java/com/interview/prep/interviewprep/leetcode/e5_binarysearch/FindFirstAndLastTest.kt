package com.interview.prep.interviewprep.leetcode.e5_binarysearch

import com.interview.prep.interviewprep.leetcode.e4_stackqueque.queque.monotonic.SlidingWindowMaximum
import org.junit.Assert.assertEquals
import org.junit.Test

class FindFirstAndLastTest {
    // 1. Instantiate the class to test
    private val solution = FindFirstAndLast()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val target : Int,
        val expected: IntArray,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testFindFirstAndLast() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(5,7,7,8,8,10),
                target=8,
                expected = intArrayOf(3,4),
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(5,7,7,8,8,10),
                target=6,
                expected = intArrayOf(-1,-1),
                message = "Case 2"
            ),
            TestCase(
                input = intArrayOf(),
                target=0,
                expected = intArrayOf(-1,-1),
                message = "Case 3"
            ),
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input,test.target)
            println(" Test : ${test.input.contentToString()} | result : ${actual.joinToString(",")} | expected : ${test.expected.joinToString(",")}")
            assertEquals("Failed on: ${test.message}",test.expected.joinToString(","), actual.joinToString(","))
        }
    }
}