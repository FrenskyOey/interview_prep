package com.interview.prep.interviewprep.leetcode.e5_binarysearch

/**
 * ==========================================
 * PROBLEM: 33. Search in Rotated Sorted Array
 * ==========================================
 *
 * URL: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * DESCRIPTION:
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,8,9,0,1,2], target = 1
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 *
 *
 */

class SearchSortRotatedArrays {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: BinarySearch
     *
     * Strategy:
     * untuk ini kita masih menggunakan binary search cuman setelah di dapat nilai tengahnya ada beberapa algoritma yang tetap harus diimplementasikan dengan rules seperti ini
     * 1. jika target < nilai tengah
     * - kita harus cek juga apakah target < nilai index awal (start) kalau dia lebih kecil berarti dia ada di rotated sort dan kita buat posisi startnya = midle + 1
     * - kalau target > nilai index awal, berarti nilainya ada sebelum rotated sort sehingga bisa kita buat index end = midle -1
     * 2. jika target > nilai tengah
     * - ini langsung saja buat index startnya = midle + 1.. karena baik nilai sebelum rotated dan sesudah rotated berurutan dari kecil ke besar
     * 3. jika index awal > index akhir.. end nga ada result return -1
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

    fun execute(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size-1
        var result = -1
        var isFound = false
        while(start <= end && !isFound){
            val midle = start + (end-start)/2
            val value = nums[midle]
            if(value == target){
                result = midle
                isFound = true
                continue
            }

            val startValue = nums[start]
            val endValue = nums[end]

            // Identify which half is sorted
            if (startValue <= value) {
                // Left side is sorted
                if (target >= startValue && target < value) {
                    end = midle - 1 // Target is in the sorted left
                } else {
                    start = midle + 1 // Target is in the right
                }
            } else {
                // Right side is sorted
                if (target > value && target <= endValue) {
                    start = midle + 1 // Target is in the sorted right
                } else {
                    end = midle - 1 // Target is in the left
                }
            }
        }
        return result
    }

}