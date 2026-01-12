package com.interview.prep.interviewprep.leetcode.e1_array_hashing.prefixsum

/**
 * ==========================================
 * PROBLEM: 303. Range Sum Query - Immutable
 * ==========================================
 *
 * URL: https://leetcode.com/problems/range-sum-query-immutable/description/
 *
 * DESCRIPTION:
 *
 * Given an integer array nums, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 *
 * Example 1:
 *
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 *
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= left <= right < nums.length
 * At most 104 calls will be made to sumRange.
 *
 */

class RangeSum(val nums : IntArray) {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Prefix Sum
     *
     * Strategy:
     *
     * Untuk memecahkan masalah ini, kita bisa menggunakan metode prefix sum, Intinya pertama kali kita buat dulu array yang isi tiap
     * elemennya adalah jumlah total dari setiap elemen yang ada di array
     * mislkan
     * input :  [-2, 0, 3, -5, 2, -1]
     * maka prefixnya adalah
     * prefixSum : [-2, -2, 1 , -4, -2, -3]
     * dimana
     * prefix 0 = -2
     * prefix 1 = -2 + 0 = -2
     * prefix 2 = -2 + 3 = 1
     * prefix 3 = 1 - 5 = -4
     * dst
     *
     * setelah array prefixSum di dapat maka kita bisa mendapatkan nilai range sum dengan algoritma / perhitungan seperti berikut
     * target = prefixSum[lastIndex] - prefixSum[firstIndex-1]
     *
     * intinya jumlah range adalah jumlah semua total sum sampai ke last index dikurnag jumlah total semua total sebelum first index
     * dengan begitu kita bisa mengurang logic O(N)square jadi O(N)
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

    fun sumRange(left: Int, right: Int): Int {
        val totalArray = ArrayList<Int>()
        var indexes = 0
        var totalSums = 0
        while(indexes < nums.size){
            totalSums = totalSums + nums[indexes]
            totalArray.add(totalSums)
            indexes = indexes + 1
        }

        var totalLeft = 0
        if((left - 1) > 0){
            totalLeft = totalArray.get((left-1))
        }


        var result = totalArray.get(right) - totalLeft

        return result
    }

}