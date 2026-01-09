package com.interview.prep.interviewprep.leetcode.e2_twopointers

/**
 * ==========================================
 * PROBLEM: 11. Container With Most Water
 * ==========================================
 *
 * URL: https://leetcode.com/problems/container-with-most-water/description/
 *
 * DESCRIPTION:
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 */

class WaterContainer {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Two Pointer
     *
     * Strategy:
     *
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     *
     * Ini caranya bisa pake two sum dimana kita pakai pointer kiri dan kanan, nanti si pointernya bakal maju dari perbandingan tinggi
     * kalau tinggi kanan lebih pendek dari kiri maka pointer kanan mundur
     * kalau tinggi kiri lebih pendek maka kiri yang maju
     * nanti luasnya bisa di cari lewat tinggi terpendek * jarak pointer kiri dan pointer kanan (pointer kanan - pointer kiri + 1)
     * simpen juga current maksimum.. kalau current maksimum lebih kecil dari luas yang di dapat ya tinggal diupdate valuenya
     *
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(height: IntArray): Int {
        var pointer1 = 0
        var pointer2 = height.size - 1
        var maxArea = 0

        while(pointer2 > pointer1){
            var heightz = 1
            val width = pointer2 - pointer1

            if(height[pointer1] < height[pointer2]){
                heightz = height[pointer1]
                pointer1 = pointer1 + 1
            }else{
                heightz = height[pointer2]
                pointer2 = pointer2 - 1
            }

            val currentArea = heightz * width
            if(currentArea > maxArea){
                maxArea = currentArea
            }
        }

        return maxArea
    }

}