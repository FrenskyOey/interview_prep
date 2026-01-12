package com.interview.prep.interviewprep.leetcode.e1_array_hashing.prefixsum

/**
 * ==========================================
 * PROBLEM: 525. Contiguous Array
 * ==========================================
 *
 * URL: https://leetcode.com/problems/contiguous-array/description/
 *
 * DESCRIPTION:
 *
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Example 3:
 *
 * Input: nums = [0,1,1,1,1,1,0,0,0]
 * Output: 6
 * Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 *
 */


class ContigousArray {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Hashmap Dan prefix sum
     *
     * sample dulu
     * jadi kita rumuskan dulu desifinisi Contiguous Array
     * jadi si array ini cuman mengharapkan jumlah 1 dan 0 yang ada di dalam arraynya tuh sama
     * jadi mau dia
     * 1100
     * 0110
     * 0011
     * 1001
     *
     * itu contiguous karena jumlah 1 = 2 dan jumlah 0 = 2
     *
     * untuk meresolve masalah ini, kita bisa menggunakan hashmap yang menyimpan dan mengtrack current different dari 1 dan 0
     * lalu nanti kalau misalkan hasilnya sudah ada di hashmap berarti kita sudah menemukan ujung dari arraynya dan bisa kita hitung panjangnya
     * untuk mempersimpel contoh soal kaya gini
     *
     * 11100
     *
     * >1 1 1 0 0
     *  c1 = 1
     *  c0 = 0
     *  dif = 1-0 = 1
     *  h[1] = not found -> h[1] = 0
     *
     *  terus sampe 1 1 >1 0 0
     *  c1 = 3
     *  c0 = 0
     *  dif = 3-0 = 3
     *  h[3] = not found -> h[3] = 2
     *
     *  1 1 1 >0 0
     *  c1 = 3
     *  c0 = 1
     *  dif = 3-1 = 2
     *
     *  h[1] = 0
     *  h[2] = 1
     *  h[3] = 2
     *  length = index - h[2] = 3 - 1 = 2
     *
     *  1 1 1 0 >0
     *  c1 = 3
     *  c0 = 2
     *  dif = 3 - 2 = 1
     *
     *  h[1] = 0
     *  h[2] = 1
     *  h[3] = 2
     *  length = index - h[1] = 4 - 0 = 4
     *
     * Strategy:
     *
     * Algorithm
     *
     * Complexity Analysis: O(N)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(nums: IntArray): Int {
        var counter0 = 0
        var counter1 = 0

        var hashmap : HashMap<Int,Int> = HashMap()
        var currentMax = 0
        var indexes = 0
        for(data in nums){
            if(data == 0){
                counter0 += 1
            }else{
                counter1 += 1
            }

            val difference = counter1 - counter0

            // autobalances so auto maximum based on last data
            if(difference == 0){
                currentMax = counter0 + counter1
            }else if(hashmap.contains(difference)){
                // handling for unbalances data
                // find the distances
                val distances = indexes - hashmap[difference]!!
                currentMax = maxOf(currentMax, distances)
            }else{
                // we store the differences into hashmap for next itteration
                hashmap[difference] = indexes
            }
            indexes = indexes+1
        }
        return currentMax
    }

}