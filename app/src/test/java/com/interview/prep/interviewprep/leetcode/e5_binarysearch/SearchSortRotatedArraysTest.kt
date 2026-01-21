package com.interview.prep.interviewprep.leetcode.e5_binarysearch

import org.junit.Assert.assertEquals
import org.junit.Test

class SearchSortRotatedArraysTest {
    // 1. Instantiate the class to test
    private val solution = SearchSortRotatedArrays()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val target : Int,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testFindFirstAndLast() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(5,1,3),
                target= 3,
                expected = 2,
                message = "Case 5"
            ),
            TestCase(
                input = intArrayOf(4,5,6,7,8,1,2,3),
                target= 8,
                expected = 4,
                message = "Case 4"
            ),
            TestCase(
                input = intArrayOf(5,1,3),
                target= 5,
                expected = 0,
                message = "Case 0"
            ),
            TestCase(
                input = intArrayOf(4,5,6,7,0,1,2),
                target= 0,
                expected = 4,
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(4,5,6,7,0,1,2),
                target=3,
                expected = -1,
                message = "Case 2"
            ),
            TestCase(
                input = intArrayOf(1),
                target=0,
                expected = -1,
                message = "Case 3"
            ),
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input,test.target)
            println(" Test : ${test.input.contentToString()} | result : ${actual} | expected : ${test.expected}")
            assertEquals("Failed on: ${test.message}",test.expected, actual)
        }
    }
}