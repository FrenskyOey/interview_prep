package com.interview.prep.interviewprep.leetcode.e6_linkedlist

import com.interview.prep.interviewprep.ListNode

/**
 * ==========================================
 * PROBLEM: 61. Rotate List
 * ==========================================
 *
 * URL: https://leetcode.com/problems/rotate-list/description/
 *
 * DESCRIPTION:
 * Given the head of a linked list, rotate the list to the right by k places.
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * Example 2:
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 *
 */

class RotatedLinkListed {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Link List
     *
     * Strategy:
     *
     *  untuk ini kita ada 2 kondisi,
     *  1 jika k itu lebih kecil dari size link listed
     *  2. jika k lebih besar dari size link listed
     *
     *  untuk solusi dari saya kita bisa buat dulu 2 pointer
     *  start, dan end
     *  start akan maju duluan sedangkan end baru jalan ketika jarak start dan
     *  titik awal sudah = k
     *
     *  nanti si titik start dan end akan maju sampai si start menemui start.next = null
     *  nah kalau misalkan si pointer end sudah mempunyai nilai
     *  artinya masuk ke kondisi 1 dimana k lebih kecil dari size, di sini
     *  pertama kita akan buat resultnya dengan nilai result = end.next, sesudah itu
     *  link list end.next akan kita set ke null, sedangkan star.net akan kita pasangkan ke head
     *  sesudah itu resultnya tinggal kita return kan
     *
     *  tetapi kalau misalkan nilai endnya masih null (kasus ke 2), nah di sini kita bakal menghitung nilai
     *  k baru dengan rumus = k = sizelinklist % k misalkan di kasus 2 berarti 3 % 4 = 1 lalu tinggal kita rekursif atau panggil fungsinya lagi
     *  dengan parameter yang baru
     *
     *  contoh exercise 1
     *  1,2,3,4,5  k =2
     *  nanti iterasinya bakal mulai kaya gini
     *  start = 1,2,3,4,5
     *  nah begitu sudah sampai jarak ke 2 maka jadi gini
     *  end=1,2,start=3,4,5
     *  nah nanti endingnya bakal gini
     *  1,2,end=3,4,start=5
     *  di sini resultnya berart end.next = 4,5 dimana 5 akan kita pasangkan ke head jadinya 4,5,1,2,3,null
     *
     * exercise 2
     *  0,1,2 k = 4
     *  nanti hasil akhirnya bakal gini
     *  0,1,start = 2 size = 3, nilai pointer end masih empty
     *  berarti bakal dibuat nilai k baru k = 4%3 = 1
     *  return rotatedList(head,1)
     *
     *
     * Algorithm
     *
     * Complexity Analysis:
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(head: ListNode<Int>, k: Int): ListNode<Int> {
        var size = 0
        var start = head
        var end : ListNode<Int>? = null
        var step = -1

        if(k == 0){
            return head
        }

        var shouldStop = false
        while(shouldStop == false){
            step = step + 1
            size = size + 1

            if(step == k){
                end = head
            }

            if(start.next == null){
                shouldStop = true
                continue
            }

            start = start.next!!
            if(end != null){
                end = end.next!!
            }
        }

        if(end != null){
            var result = end.next!!
            end.next = null
            start.next = head
            return result
        }

        val newItteration = k % size
        return execute(head,newItteration)
    }

}