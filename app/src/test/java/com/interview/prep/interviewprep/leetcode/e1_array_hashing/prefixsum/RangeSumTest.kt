package com.interview.prep.interviewprep.leetcode.e1_array_hashing.prefixsum

import org.junit.Assert.assertEquals
import org.junit.Test

class RangeSumTest {
    // 1. Instantiate the class to test
    private val solution = ProductExclude()

    // 2. Define the Test Case data structure
    data class Query(
        val left: Int,
        val right: Int,
        val expected: Int
    )

    data class NumArrayTestCase(
        val nums: IntArray,
        val queries: List<Query>,
        val description: String
    )

    @Test
    fun testProductExclude() {
        // 3. Define scenarios
        val testCases = listOf(
            NumArrayTestCase(
                nums = intArrayOf(-2, 0, 3, -5, 2, -1),
                queries = listOf(
                    Query(0, 2, 1),   // -2 + 0 + 3 = 1
                    Query(2, 5, -1),  // 3 + (-5) + 2 + (-1) = -1
                    Query(0, 5, -3)   // sum of all = -3
                ),
                description = "Standard case with negatives"
            )
        )

        // 4. Run the loop
        for (test in testCases) {
            println("=== Testing: ${test.description} ===")
            println("Input Array: ${test.nums.contentToString()}")

            // Initialize the class (this is where you do your prefix sum logic)
            val numArray = RangeSum(test.nums)

            for (query in test.queries) {
                val actual = numArray.sumRange(query.left, query.right)

                val status = if (actual == query.expected) "✅" else "❌"
                println("  Range [${query.left}, ${query.right}] | Expected: ${query.expected} | Actual: $actual $status")

                assertEquals(
                    "Failed range [${query.left}, ${query.right}] in ${test.description}",
                    query.expected,
                    actual
                )
            }
            println("-------------------------------------------\n")
        }
    }
}
