package com.interview.prep.interviewprep.leetcode.e2_twopointers

import kotlin.text.contains

/**
 * ==========================================
 * PROBLEM: 15. 3Sum
 * ==========================================
 *
 * URL: https://leetcode.com/problems/3sum/description/
 *
 * DESCRIPTION:
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 */

class ThreeSum {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Two Pointer
     *
     * Strategy:
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     *
     * ini sebetulnya kasus two pointer
     * dimana hasil two pointernya harus = data[i]
     * jadinya nanti data[i] = data[j] + data[k]
     *
     * dan index i bakal maju setiap kali kita udah dapet hasil seluruh kemungkinan two pointer yang di dapat
     * cuman satu syarat pasti si array numsnya harus kita sort dulu.. kalau nga nga bakal bener hasil two sumnya
     *
     * simulasi -> liat web aja ya.. ribet aku jelasinnya
     * [-1 0 1 2 -1 -4] -> [-4 -1 -1 0 1 2]
     *
     *  yang pasti -4 harus cari negasinya yaitu +4 maka harus cari two sum yang hasilnya 4, kalau nga nemu maka skip ke array berikutnya
     *
     *
     * Complexity Analysis: O(n kuadrat)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/
    private fun foundPreSum(target : Int, data : IntArray): ArrayList<ArrayList<Int>>{
        // *-1 because to make 0 need negation of target so target - target = 0
        val resultTarget = target * -1
        var pointerRight = data.size -1
        var pointerLeft = 0
        val hashKey : HashMap<String, Boolean> = hashMapOf()
        val rezult : ArrayList<ArrayList<Int>> = arrayListOf()

        while(pointerLeft < pointerRight){
            val totalSum = data[pointerLeft] + data[pointerRight]
            // store daya if total sum matches
            if(totalSum == resultTarget){
                // avoid duplicate data by checking hashmap
                val keys = "${data[pointerLeft]},${data[pointerRight]}"
                if(!hashKey.contains(keys)){
                    hashKey[keys] = true
                    rezult.add(arrayListOf(target,data[pointerLeft],data[pointerRight]))
                }
            }

            // two pointer here
            if(totalSum < resultTarget){
                pointerLeft = pointerLeft + 1
            }else{
                pointerRight = pointerRight - 1
            }
        }

        return rezult
    }

    fun execute(nums: IntArray): List<List<Int>> {
        val hashKey : HashMap<Int, Boolean> = hashMapOf()
        val result = arrayListOf<ArrayList<Int>>()
        // we need to sort for applying 2 sum
        nums.sort()
        var indexes = 0
        while(indexes <= nums.size - 3){
            // skip if the number already calculated before
            if(hashKey.contains(nums[indexes])){
                indexes = indexes + 1
                continue
            }
            // silce the array
            val startIndex = indexes+1
            val endIndex = nums.size

            val preSums = foundPreSum(nums[indexes],nums.copyOfRange(startIndex,endIndex))
            if(!preSums.isEmpty()){
                //save to skip a number that already calculated
                hashKey[nums[indexes]] = true
                result.addAll(preSums)
            }

            indexes = indexes + 1
        }
       return result
    }
}