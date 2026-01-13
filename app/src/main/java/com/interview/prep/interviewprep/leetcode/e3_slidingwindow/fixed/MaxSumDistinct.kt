package com.interview.prep.interviewprep.leetcode.e3_slidingwindow.fixed


/**
 * ==========================================
 * PROBLEM: 2461. Maximum Sum of Distinct Subarrays With Length K
 * ==========================================
 *
 * URL: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
 *
 * DESCRIPTION:
 *
 * You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
 *
 * The length of the subarray is k, and
 * All the elements of the subarray are distinct.
 * Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 *
 * Input: nums = [1,5,4,2,9,9,9], k = 3
 * Output: 15
 * Explanation: The subarrays of nums with length 3 are:
 * - [1,5,4] which meets the requirements and has a sum of 10.
 * - [5,4,2] which meets the requirements and has a sum of 11.
 * - [4,2,9] which meets the requirements and has a sum of 15.
 * - [2,9,9] which does not meet the requirements because the element 9 is repeated.
 * - [9,9,9] which does not meet the requirements because the element 9 is repeated.
 * We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
 * Example 2:
 *
 * Input: nums = [4,4,4], k = 3
 * Output: 0
 * Explanation: The subarrays of nums with length 3 are:
 * - [4,4,4] which does not meet the requirements because the element 4 is repeated.
 * We return 0 because no subarrays meet the conditions.
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 */



class MaxSumDistinct {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Sliding Windows
     *
     * Strategy:
     * Input: nums = [1,5,4,2,9,9,9], k = 3
     * Output: 15
     *
     * Intinya di sini, karena sudah di kasih panjang arraynya harus 3 dan nga boleh ada yang sama komponennya
     * otomatis ini adalah persoalan sliding windows fix, untuk resolvenya kita harus buat komponen hashmap
     * buat ngetrack kondisi distinct ada atau tidak. setiap kita geser arraynya maka kita harus menghapus hashmap terakhir
     * dan menambahkan hashmap yang sudah ada.. kalau pas di cek elemennya sudah ada maka kita skip
     *
     *  simulasi
     *  [1,5,4],2,9,9,9
     *  hashmap : 1 : 1, 5: 1, 4 1
     *  sum = 1+5+4 = 10
     *  currentMax = 10
     *
     *  1,[5,4,2],9,9,9
     *  hashmap : remove(1) 5: 1, 4 1, 2 : 1
     *  sum = 10 - 1 + 2 = 11
     *  currentMax = 11
     *
     *  1,5,[4,2,9],9,9
     *  hashmap : remove(5) 4 1, 2 : 1, 9 : 1
     *  sum = 11 - 5 + 9 = 15
     *  currentMax = 15
     *
     *  1,5,4,[2,9,9],9
     *  hashmap : remove(4) 2 : 1, 9 : 2
     *  sum = 15 - 4 + 9 = 20
     *  9 isExist skip counter max
     *
     *  1,5,4,2,[9,9,9]
     *  hashmap : remove(2) 9 : 3
     *  sum = 20 - 2 + 9 = 27
     *  9 isExist skip counter max
     *
     *  result currentMax = 15
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

    fun execute(nums: IntArray, k: Int): Long {
        val hashMap : HashMap<Int, Int> = hashMapOf()
        var currentSum = 0L
        var currentMax = 0L
        var start = 0
        var end = 0

        for(data in nums){
            // kita isi dulu data hashmap awalnya
            if(end < k){
                currentSum = currentSum + data
                val counters = hashMap[data] ?: 0
                hashMap[data] = counters + 1

                if(end == k-1){
                    //kita cek kalau data hasmap = size window maka artinya distinct, kalau misalkan kurang maka pasti ada yang ganda
                    if(hashMap.size == k){
                        currentMax = currentSum
                    }
                }

                end = end + 1
                continue
            }

            //proses start pointer, setiap ada pergeseran start, pasti ada pengurangan
            val startData = nums[start]
            var startCounter = hashMap[startData] ?: 1
            startCounter = startCounter - 1
            // kalau 0 artinya data hashmapnya kita hapus agar size hashmapnya juga berkurang
            if(startCounter == 0){
                hashMap.remove(startData)
            }else{
                hashMap[startData] = startCounter
            }

            //proses end pointer, setiap endpointer bergerser, maka kita akan menambahkan datanya ke hashmap
            val endCounter = hashMap[data] ?: 0
            hashMap[data] = endCounter + 1

            // hitung current sum di sliding windows
            currentSum = currentSum + data - startData

            if(hashMap.size == k){
                currentMax = maxOf(currentMax,currentSum)
            }

            end = end + 1
            start = start + 1
        }

        return currentMax
    }
}