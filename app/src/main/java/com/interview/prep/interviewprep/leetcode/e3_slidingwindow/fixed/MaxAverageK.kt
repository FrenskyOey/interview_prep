package com.interview.prep.interviewprep.leetcode.e3_slidingwindow.fixed
/**
 * ==========================================
 * PROBLEM: 643. Maximum Average Subarray I
 * ==========================================
 *
 * URL:https://leetcode.com/problems/maximum-average-subarray-i/description/
 * difficulty easy
 * DESCRIPTION:
 *
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 *
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 */

class MaxAverageK {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Fixed Sliding Windows
     *
     *
     * Strategy:
     * Input: nums = [1,12,-5,-6,50,3], k = 4
     * Output: 12.75000
     * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     *
     * sebetulnya untuk meresolve ini, kita cukup mencari nilai sum maksimum dari setiap subarray
     * ini karena sudah di kunci si size arraynya = k, dan di suruh mencari subarray berarti udah pasti sliding windows
     *
     * mekanisme pertama itu kita tentukan dulu pointer awal dan pointer akhir lalu
     * nanti kita juga bakal ngerecord nilai sum dari sub array yang lagi di proses
     * berikut mekanismenya
     *
     * i1 =  >1, 12 , -5 , -6 , 50 , 3
     * p1 = 0 , p2 = 0, sum = 0+1 = 1
     * karena i1 < k maka langsung tambah p2
     * i2 = p1>1 , p2>12 , -5, -6, 50, 3
     * p1 = 0 , p2 = 1 , sum = 1 + 12 = 13
     * karena i2 < k maka langsung tambah p2
     * i3 = p1>1 , 12 , p2>-5, -6, 50, 3
     * p1 = 0 , p2 = 2 , sum = 13-5 = 8
     * i4 = p1>1 , 12 , -5, p2>-6, 50, 3
     * p1 = 0 , p2 = 3 , sum = 8-6 = 2 maxSum = 2
     * nah ini karena i4 sudah = K maka saatnya kita tambahin p2 dan p1 samaan
     * i5 = 1 , p1>12 , -5, -6, p2>50, 3
     * p1 = 1 , p2 = 4 , sum = 1 - 1(bekas p1) + 50(punya p2) = 51   maxSum = 51
     * i6 = 1 , 12 , p1>-5, -6, 50, p2>3
     * p1 = 2 , p2 = 5 , sum = 50 - 12(bekas p1) + 3(punya p2) = 31   maxSum = 50
     *
     * jawabannya adalah 51/4 = 12,75
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

    fun execute(nums: IntArray, k: Int): Double  {
        var currentSum = 0
        var maxSum = 0

        var start = 0
        var end = 0

        for(data in nums){
            // inisiasi data maxSum dulu di sini, dengan memajika pointer end sampai k-1
            if(end < k){
                currentSum = currentSum + data
                if(end == k-1){
                    maxSum = currentSum
                }
                end = end + 1
                continue
            }

            // di sini kalkulasi window sliding terjadi, untuk setiap pointer end akan ditambahkan dan untuk pointer start akan dikurangkan
            currentSum = currentSum + data - nums[start]

            // di sini kita compare maxSum sekarang sama yang lalu
            if(maxSum < currentSum){
                maxSum = currentSum
            }

            start = start + 1
            end = end + 1
        }

        return maxSum.toDouble()/k.toDouble()
    }

}