package com.interview.prep.interviewprep.leetcode.e6_linkedlist.pointer

import com.interview.prep.interviewprep.ListNode

/**
 * ==========================================
 * PROBLEM: 876. MidleLinkList
 * ==========================================
 *
 * URL:https://leetcode.com/problems/middle-of-the-linked-list/description/
 *
 * DESCRIPTION:
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 *
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 *
 */

class MidleLinkList {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: XXX
     *
     * Strategy:
     * // ini sebetulnya caranya simple, tinggal buat 2 pointer cuman punya kecepatan berbeda
     * pointer satu itu jalannya cuman 1 kali aja manggil .nextnya
     * sedangkan pointer 2 itu manggil nextnya 2 kali
     * karena secara rumus pointer 2 itu nilainya adalah 2 kali dari pointer satu, jadinya rentang jaraknya juga
     * 2 kali dari rentang jarang pointer 1, kalau pasa saat .next hasilnya null.. berarti kita bisa langsung memberikan result
     * pointer 1 sebagai jawabannya
     *
     * Algorithm
     *
     * misalkan
     * 1 , 2 , 3 , 4 , 5
     * awal
     * p1,p2 -> 1, 2, 3, 4, 5
     * i1
     * 1,p1 -> 2, p2 -> 3,4,5
     * di sini p1 hanya .next sekali, sedangkan p2 .next 2 kali
     * i2
     * 1,2,p1 -> 3 , 4, p2 ->5
     * kita cek di sini karena p2.nextnya null langsung tau jawabannya
     *
     * bagiaman kalau 6
     * i3
     * 1,2,3, p1 -> 4, 5, 6  karena di sini p2 sudah null.. maka jawabannya langsung p1 yaitu 4,5,6
     *
     *
     * Complexity Analysis:
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(head: ListNode<Int>): ListNode<Int> {
        var p1 : ListNode<Int> = head
        var p2 : ListNode<Int>? = head

        while(p2 != null && p2.next != null){
            p1.next?.let {
                p1 = it
            }
            p2 = p2?.next
            p2 = p2?.next
        }

        return p1!!
    }

}