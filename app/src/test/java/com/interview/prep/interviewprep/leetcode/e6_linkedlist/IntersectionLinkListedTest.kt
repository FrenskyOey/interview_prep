package com.interview.prep.interviewprep.leetcode.e6_linkedlist

import com.interview.prep.interviewprep.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test

class IntersectionLinkListedTest {
    // 1. Instantiate the class to test
    private val solution = IntersectionLinkListed()

    // 2. Define the Test Case data structure
    data class TestCase(
        val inputA: ListNode<Int>,
        val inputB: ListNode<Int>,
        val expected: ListNode<Int>?,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testIntersectionLinkListed() {
        // 3. Define scenarios
        val testCases = mutableListOf<TestCase>()

        // --- CASE 1: Standard Intersection (LeetCode Example 1) ---
        // List A: 4 -> 1 -\
        //                  8 -> 4 -> 5
        // List B: 5 -> 6 -> 1 -/

        val intersectNode1 = ListNode(8, ListNode(4, ListNode(5)))
        val headA1 = ListNode(4, ListNode(1))
        val headB1 = ListNode(5, ListNode(6, ListNode(1)))
        headA1.connectNextNode(intersectNode1)
        headB1.connectNextNode(intersectNode1)

        testCases.add(TestCase(
            inputA = headA1,
            inputB = headB1,
            expected = intersectNode1, // Expect the exact object 'intersectNode1'
            message = "Standard intersection in the middle"
        ))

        // --- CASE 2: No Intersection (LeetCode Example 2) ---
        // List A: 2 -> 6 -> 4 -> null
        // List B: 1 -> 5 -> null

        val headA2 = ListNode(2, ListNode(6, ListNode(4)))
        val headB2 = ListNode(1, ListNode(5))

        testCases.add(TestCase(
            inputA = headA2,
            inputB = headB2,
            expected = null,
            message = "No intersection"
        ))

        // --- CASE 3: Intersection at the very end ---
        // List A: 1 -\
        //             3 (shared)
        // List B: 2 -/

        val commonEnd = ListNode(3)
        val headA3 = ListNode(1)
        val headB3 = ListNode(2)

        headA3.connectNextNode(commonEnd)
        headB3.connectNextNode(commonEnd)

        testCases.add(TestCase(
            inputA = headA3,
            inputB = headB3,
            expected = commonEnd,
            message = "Intersection at the last node"
        ))


        // --- CASE 4: One list is a sub-list of the other (Head Intersection) ---
        // List A:       \
        //                10 -> 11
        // List B:  9 -> /
        // (A starts exactly where they intersect)

        val commonPart4 = ListNode(10, ListNode(11))
        val headA4 = commonPart4 // A is the shared part itself
        val headB4 = ListNode(9)
        headB4.connectNextNode(commonPart4)

        testCases.add(TestCase(
            inputA = headA4,
            inputB = headB4,
            expected = commonPart4,
            message = "Intersection is the head of List A"
        ))

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.inputA,test.inputB)
            println(" Test Input A : ${test.inputA.toString()} | input B : ${test.inputB.toString()} | result : ${actual.toString()} | expected : ${test.expected.toString()}")
            assertEquals("Failed on: ${test.message}",test.expected, actual)
        }
    }
}