package com.interview.prep.interviewprep.leetcode.e2_twopointers

import org.junit.Test

class ThreeSumTest {
    // 1. Instantiate the class to test
    private val solution = ThreeSum()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: IntArray,
        val expected: List<List<Int>>,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testThreeSum() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase(
                input = intArrayOf(-1,0,1,2,-1,-4),
                expected = arrayListOf(arrayListOf(-1,-1,2),arrayListOf(-1,0,1)),
                message = "Case 1"
            ),
            TestCase(
                input = intArrayOf(0,1,1),
                expected = arrayListOf(),
                message = "Case 2"
            ),
            TestCase(
                input = intArrayOf(0,0,0),
                expected = arrayListOf(arrayListOf(0,0,0)),
                message = "Case 3"
            ),
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input)

            // 1. Normalize both lists for a fair comparison
            val normalizedActual = actual.map { it.sorted() }.sortedBy { it.joinToString(",") }
            val normalizedExpected = test.expected.map { it.sorted() }.sortedBy { it.joinToString(",") }

            // 2. Print the results clearly
            println("--- Testing: ${test.message} ---")
            println("Input    : ${test.input.contentToString()}")
            println("Actual   : $normalizedActual")
            println("Expected : $normalizedExpected")

            // 3. Assert
            assert(normalizedActual == normalizedExpected) {
                "Failed on: ${test.message}\nExpected: $normalizedExpected\nActual: $normalizedActual"
            }
            println("--------------------------------------\n")
        }
    }
}