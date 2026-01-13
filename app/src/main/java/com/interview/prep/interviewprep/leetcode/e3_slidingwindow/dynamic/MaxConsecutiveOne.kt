package com.interview.prep.interviewprep.leetcode.e3_slidingwindow.dynamic

/**
 * ==========================================
 * PROBLEM: 1004. Max Consecutive Ones III
 * ==========================================
 *
 * URL:https://leetcode.com/problems/max-consecutive-ones-iii/description/
 *
 * DESCRIPTION:
 *
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 *
 */


class MaxConsecutiveOne {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Dynamic Sliding WIndow
     *
     * Strategy:
     * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
     * Output: 6
     * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     *
     * k = 2
     * 1,1,1,0,0,0,1,1,1,1,0
     * k = 1
     * length = 4
     * [1,1,1,-1],0,0,1,1,1,1,0
     * k = 0
     * length = 5
     * [1,1,1,-1,-1],0,1,1,1,1,0
     * k = -1
     * [1,1,1,-1,-1,-1],1,1,1,1,0
     * start point start to move to make it 0
     * 1,1,1[-1,-1,-1],1,1,1,1,0
     * -1 detected kita tambahin k = 0
     * 1,1,1-1,[-1,-1],1,1,1,1,0
     * di sini kita tinggal majuin lagi si pointer left
     * 1,1,1-1,[-1,-1,1,1,1,1],0
     * length = 6
     * k=-1 ya tinggal lakuin kaya yang tadi aja
     * 1,1,1-1,[-1,-1,1,1,1,1,-1]
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

    fun execute(nums: IntArray, k: Int): Int {
        var counterK = k
        var start = 0
        var end = 0
        var currentLength = 0
        var maxLength = 0
        var testData : IntArray = nums.copyOf()

        for(data in testData){
            if(data == 0){
                counterK = counterK - 1
                while(counterK < 0){
                   val startValue = testData[start]
                    start = start + 1
                   if(startValue == 1){
                       continue
                   }
                    counterK = counterK + 1
                }
            }

            currentLength = end - start + 1

            if(maxLength < currentLength){
                maxLength = currentLength
            }
            end = end + 1
        }

        return maxLength
    }


    fun execute2(nums: IntArray, k: Int): Int {
        var currentZero = 0
        var start = 0
        var end = 0
        var maxLength = 0

        for(data in nums){
            if(data == 0){
                currentZero = currentZero + 1
            }

            while(currentZero > k){
                val startValue = nums[start]
                if(startValue == 0){
                    currentZero = currentZero - 1
                }
                start = start + 1
            }
            println("start : $start, end : $end, currentZer : $currentZero")
            maxLength = maxOf(maxLength, end - start + 1)
            end = end +1
        }
        return maxLength
    }

}