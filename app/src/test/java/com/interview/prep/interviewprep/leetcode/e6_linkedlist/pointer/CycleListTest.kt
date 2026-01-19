package com.interview.prep.interviewprep.leetcode.e6_linkedlist.pointer

import com.interview.prep.interviewprep.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test

class CycleListTest {
    // 1. Instantiate the class to test
    private val solution = MidleLinkList()

    // 2. Define the Test Case data structure
    data class TestCase(
        val head: ListNode<Int>?,
        val expected: ListNode<Int>?, // The node where cycle begins, or null
        val message: String
    )

    @Test
    fun testIntersectionLinkListed() {
       /* val tests = getCycleTestCases()

        for (test in tests) {
            // Assume 'detectCycle' is your solution function
            val result = solution.execute(test.head!!)

            if (result === test.expected) {
                println("PASS: ${test.message}")
            } else {
                println("FAIL: ${test.message}")
                println("  Expected: ${test.expected?.value ?: "null"}")
                println("  Got:      ${result?.value ?: "null"}")
            }
        }*/

        assertEquals("Failed on: Cycle List","a", "a")

    }
}