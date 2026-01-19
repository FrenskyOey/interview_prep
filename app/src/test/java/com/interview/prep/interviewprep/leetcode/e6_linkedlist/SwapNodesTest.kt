package com.interview.prep.interviewprep.leetcode.e6_linkedlist

import com.interview.prep.interviewprep.ListNode
import com.interview.prep.interviewprep.toListNode
import org.junit.Assert.assertEquals
import org.junit.Test

class SwapNodesTest {
    // 1. Instantiate the class to test
    private val solution = SwapNodes()

    // 2. Define the Test Case data structure
    data class TestCase(
        val inputA: ListNode<Int>,
        val expected: ListNode<Int>?,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testSwapNodesTest() {
        // 3. Define scenarios
        val testCases = mutableListOf<TestCase>(
            TestCase(
                inputA = intArrayOf(1,2,3,4).toListNode()!!,
                expected = intArrayOf(2,1,4,3).toListNode()!!, // Expect the exact object 'intersectNode1'
                message = "Check Base Question"
            ),
            TestCase(
                inputA = intArrayOf(1).toListNode()!!,
                expected = intArrayOf(1).toListNode()!!,
                message = "Single node (no pair to swap)"
            ),
            TestCase(
                inputA = intArrayOf(1, 2, 3).toListNode()!!,
                expected = intArrayOf(2, 1, 3).toListNode()!!,
                message = "Odd length list (last node stays)"
            ),
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.inputA).toString()
            val expected = test.expected.toString()
            println(" Test Input A : ${test.inputA.toString()} | result : ${actual} | expected : ${expected}")
            assertEquals("Failed on: ${test.message}",expected, actual)
        }
    }
}