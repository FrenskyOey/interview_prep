package com.interview.prep.interviewprep.leetcode.e1_array_hashing.prefixsum
/**
 * ==========================================
 * PROBLEM: 238. Product of Array Except Self
 * ==========================================
 *
 * URL: https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * DESCRIPTION:
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 *
 *
 *
 *
 */

class ProductExclude {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Array | Prefix Sum
     *
     * Strategy:
     *
     * jadi intinya si complexity timenya hari dalam bentuk 0(N) jadi nga bisa tuh kita masukin datanya dalam bentuk for dalam for
     * cara ngakalinnya kita harus tau dulu cara kerjanya misalkan begini
     * [A , B, C, D]
     * maka arraynya harus jadi begini
     * [[B*C*D],[A]*[C*D],[A*B]*[D],[A*B*C]]
     * nah dari sini kita tau bakala da 2 komponen perkalian.
     * sisi kanan dan juga sisi kiri, dari sini keliatan polanya kalau ini pakai metode presum dimana rumusnya
     * presum perkalian dari kiri * presum perkalian dari kanan
     *
     * kiri : [A AB ABC ABCD]
     * kanan : [D CD BCD ABCD]
     *
     * result : [kanan[2], kiri[0] * kanan[1], kiri[1] * kanan[0], kiri[2]]
     *
     * ya sudah deh begitu kurang lebih
     * Algorithm
     *
     * Complexity Analysis: O(N)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(nums: IntArray): IntArray {
        val kiri = IntArray(nums.size)
        val kanan = IntArray(nums.size)

        var indexKanan = nums.size - 1
        var valueKiri = 1
        var valueKanan = 1
        // filling presum index
        for(i in 0.rangeTo(nums.size-1)){
            valueKiri = valueKiri * nums[i]
            valueKanan = valueKanan * nums[indexKanan]
            kiri[i] = valueKiri
            kanan[i] = valueKanan
            indexKanan = indexKanan - 1
        }

        val results = IntArray(nums.size)
        var indexKanans = nums.size - 1

        for(index in 0.rangeTo(nums.size-1)){
            var resultValue = 1
            indexKanans = indexKanans - 1
            if(indexKanans >= 0){
                resultValue = kanan[indexKanans]
            }
            val indexKiri = index  - 1
            if(indexKiri >= 0){
                resultValue = resultValue * kiri[indexKiri]
            }

            results[index] = resultValue
        }

        return results
    }

}