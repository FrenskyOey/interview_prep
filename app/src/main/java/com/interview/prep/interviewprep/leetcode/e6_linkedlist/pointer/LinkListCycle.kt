package com.interview.prep.interviewprep.leetcode.e6_linkedlist.pointer

import com.interview.prep.interviewprep.ListNode


/**
 * ==========================================
 * PROBLEM: 142. Linked List Cycle II
 * ==========================================
 *
 * URL: https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * DESCRIPTION:
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * Do not modify the linked list.
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list
 *
 */

class LinkListCycle {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Linked List
     *
     * Strategy:
     * Ini caranya pake fast pointer,
     * Jadinya kendala di sini adalah kita mencari kapan cycle tercipta, ini kasusnya mirip kaya intersection Link Listed (PROBLEM: 160 leet code)
     * jadi nanti kita buat 2 pointer, 1 pointer akan maju sebanyak 1 kali next
     * dan 1 pointer lagi akan berjalan lebih cepat sebanyak 2 kali next
     *
     * kalau misalkan dia cyclic, pasti nanti nilai pointer 1 dan pointer 2 bakal sama
     * kalau misalkan p2 tiba tiba bernilai null, berarti nga ada cyclic, karena link listnya berakhir
     *
     * Algorithm
     *
     * Complexity Analysis: (O (n))
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(head: ListNode<Int>?): ListNode<Int>? {
        var pointer1 = head
        var pointer2 = head
        var isFound = false
        var result : ListNode<Int>? = null

        while(isFound == false && pointer2 != null && pointer2.next != null){
            pointer1 = pointer1?.next
            pointer2 = pointer2?.next
            pointer2 = pointer2?.next

            if(pointer2 == pointer1){
                var start = head
                // found begining of cycle using find branch algorithm
                while (start != pointer1) {
                    pointer1 = pointer1?.next
                    start = start?.next
                }
                result = start
                isFound = true
            }
        }

        return result
    }

}