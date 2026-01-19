package com.interview.prep.interviewprep.leetcode.e6_linkedlist

import com.interview.prep.interviewprep.ListNode
import com.interview.prep.interviewprep.toListNode
import org.junit.Assert.assertEquals
import org.junit.Test

class RotatedLinkListTest {
    // 1. Instantiate the class to test
    private val solution = RotatedLinkListed()

    // 2. Define the Test Case data structure
    data class TestCase(
        val inputA: ListNode<Int>,
        val k: Int,
        val expected: ListNode<Int>?,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testIntersectionLinkListed() {
        // 3. Define scenarios
        val testCases = mutableListOf<TestCase>()
        val headA1 = intArrayOf(1,2,3,4,5)
        val result = intArrayOf(4,5,1,2,3)

        testCases.add(TestCase(
            inputA = headA1.toListNode()!!,
            k = 2,
            expected = result.toListNode()!!, // Expect the exact object 'intersectNode1'
            message = "Check Base Question"
        ))

        val headA2 = intArrayOf(0,1,2)
        val result2 = intArrayOf(2,0,1)

        testCases.add(TestCase(
            inputA = headA2.toListNode()!!,
            k = 4,
            expected = result2.toListNode()!!, // Expect the exact object 'intersectNode1'
            message = "Check Base Question"
        ))


        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.inputA,test.k).toString()
            val expected = test.expected.toString()
            println(" Test Input A : ${test.inputA.toString()} | k : ${test.k} | result : ${actual} | expected : ${expected}")
            assertEquals("Failed on: ${test.message}",expected, actual)
        }
    }
}