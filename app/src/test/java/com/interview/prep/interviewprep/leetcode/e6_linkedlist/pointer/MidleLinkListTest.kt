package com.interview.prep.interviewprep.leetcode.e6_linkedlist.pointer

import com.interview.prep.interviewprep.ListNode
import com.interview.prep.interviewprep.toListNode
import org.junit.Assert.assertEquals
import org.junit.Test

class MidleLinkListTest {
    // 1. Instantiate the class to test
    private val solution = MidleLinkList()

    // 2. Define the Test Case data structure
    data class TestCase(
        val inputA: ListNode<Int>,
        val expected: ListNode<Int>?,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testIntersectionLinkListed() {
        // 3. Define scenarios
        val testCases = mutableListOf<TestCase>()
        val headA1 = intArrayOf(1,2,3,4,5)
        val result = intArrayOf(3,4,5)

        testCases.add(TestCase(
            inputA = headA1.toListNode()!!,
            expected = result.toListNode()!!, // Expect the exact object 'intersectNode1'
            message = "Check Base Question"
        ))

        val headA2 = intArrayOf(1,2,3,4,5,6)
        val result2 = intArrayOf(4,5,6)

        testCases.add(TestCase(
            inputA = headA2.toListNode()!!,
            expected = result2.toListNode()!!, // Expect the exact object 'intersectNode1'
            message = "Check Base Question"
        ))


        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.inputA).toString()
            val expected = test.expected.toString()
            println(" Test Input A : ${test.inputA.toString()} | result : ${actual} | expected : ${expected}")
            assertEquals("Failed on: ${test.message}",expected, actual)
        }
    }
}