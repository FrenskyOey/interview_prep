package com.interview.prep.interviewprep.leetcode.e6_linkedlist

import com.interview.prep.interviewprep.ListNode

/**
 * ==========================================
 * PROBLEM: 24. Swap Nodes in Pairs
 * ==========================================
 *
 * URL: https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * DESCRIPTION:
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Example 2:
 * Input: head = []
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2,3]
 * Output: [2,1,3]
 *
 * Example 4:
 * Input: head = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 *
 */

class SwapNodes {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Link List
     *
     * Strategy:
     * ga ada strategy di sini, hanya main pointer link list saja
     * ngikutin soal aja ini, baca aja algo di bawah harusnya ngerti sih ya
     *
     * Algorithm
     *
     * Complexity Analysis: O(n)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(head: ListNode<Int>): ListNode<Int>? {
        var start : ListNode<Int>? = head
        var previous : ListNode<Int>? = null
        var result : ListNode<Int>? = null

        while(start?.next != null){
            var end = start.next!!
            var nextEnd = end?.next

            start.next = nextEnd
            end.next = start
            previous?.next = end

            if(result == null){
                result = end
            }
            previous = start
            start = start.next
        }

        if(result == null){
            return start
        }

        return result
    }

}