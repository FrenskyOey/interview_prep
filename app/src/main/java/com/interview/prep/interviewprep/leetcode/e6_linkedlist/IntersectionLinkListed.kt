package com.interview.prep.interviewprep.leetcode.e6_linkedlist

import com.interview.prep.interviewprep.ListNode

/**
 * ==========================================
 * PROBLEM: 160. Intersection of Two Linked Lists
 * ==========================================
 *
 * URL: https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 *
 * DESCRIPTION:
 *
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 *
 *The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 *
 * Note that the linked lists must retain their original structure after the function returns.
 *
 * Custom Judge:
 *
 * The inputs to the judge are given as follows (your program is not given these inputs):
 *
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
 *
 * Example 1:
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
 *
 * Example 2:
 *
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 * Example 3:
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 * Constraints:
 *
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 1 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 *
 */

class IntersectionLinkListed {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: XXX
     *
     * Strategy:
     *  untuk kasus ini kita harus ngakalin caranya agar si pointer List A dan pointer List B itu bisa jalan barengan
     *  dan akhirnya nilai elemen pointer A dan pointer B nya itu sama
     *  caranya tinggal kita tambahin aja list node A ke B dan B ke A
     *  karena mereka bakal punya panjang array yang sama
     *
     *  contoh
     *  List A {4,1,8,4,5} List B {5,6,1,8,4,5}
     *  nah maka ListA + List B bakal
     *  4,1,8,4,5,5,6,1,8,4,5
     *  dan List B + list A bakal
     *  5,6,1,8,4,5,4,1,8,4,5
     *
     *  nah bisa diliat kalau jumlah sizenya jadi sama.. nah ini bisa kita lakuin pengecekan arraynya sekarang dari pointer A ke pointer B satu demu satu
     *  nanti ketemu listnya ada di 8,4,5
     *
     *  tapi agar kita lebih hemat memori instead tambah, kita bisa ganti pointer A nya ke awal list B dan pointer B ke awal list A, dengan begitu kita nga perlu
     *  buat memory baru buat nampung listA + list B
     *
     *  simulai
     *  4,1,8,4,>A = 5
     *  5,6,1,8,>B = 4,5
     *
     *  nah nanti di iterasi berikutnya jadi gini
     *  4,1,8,4,5
     *  >A = 5,6,1,8,4, >B = 5
     *
     *  dan iterasi berikutnya bakal gini
     *  >B=4,1,8,4,5
     *  5,>A=6,1,8,4,5
     *
     *  yang akan berujung jadi gini
     *  4,1,>B=8,4,5
     *  5,6,1,>A=8,4,5
     *
     *
     * Algorithm
     *
     * Complexity Analysis: O(N+M)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(headA: ListNode<Int>, headB:ListNode<Int>): ListNode<Int>? {
        var pointerA :  ListNode<Int>? = headA
        var pointerB :  ListNode<Int>? = headB
        var result : ListNode<Int>? = null

        var endPointerA : ListNode<Int>? = null
        var endPointerB : ListNode<Int>? = null

        while(result == null && (pointerA != null || pointerB != null)){
            if(pointerA == pointerB){
                result = pointerA
                continue
            }

            if(pointerA != null){
                if(pointerA.next != null){
                    pointerA = pointerA.next
                }else{
                    if(endPointerA == null){
                        endPointerA = pointerA
                        pointerA = headB
                    }else{
                        pointerA = null
                    }
                }
            }

            if(pointerB != null){
                if(pointerB.next != null){
                    pointerB = pointerB.next
                }else{
                    if(endPointerB == null){
                        endPointerB = pointerB
                        pointerB = headA
                    }else{
                        pointerB = null
                    }
                }
            }
        }
        return result
    }

}



