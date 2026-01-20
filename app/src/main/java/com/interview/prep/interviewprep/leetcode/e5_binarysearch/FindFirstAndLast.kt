package com.interview.prep.interviewprep.leetcode.e5_binarysearch

/**
 * ==========================================
 * PROBLEM: 34. Find First and Last Position of Element in Sorted Array
 * ==========================================
 *
 * URL: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * DESCRIPTION:
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 *
 *
 *
 */

class FindFirstAndLast {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: BinarySearch
     *
     * Strategy:
     * di sini kita bakal pakai 2 kali pencarian
     * 1.find first, intinya kita cari nilai array yang nilainya = target cuman sisi kirinya bukan target
     * 2.find last, intinya kita cari nilai array yang nilainya = target cuman sisi kananya bukan target
     *
     * example 1
     * find first
     * [5,7,7,8,8,10], target = 8
     * index calon = 6/2 = 3 array [3] = 8 karena dia 8 maka kita langsung pakai pencarian dari sisi kiri berarti cari dati
     * index 0-2
     * i2 = indexcalon = roundUp(3/2) = 2 = 7 karena sebelah kanan = 8 maka jawaban first adalah 7
     *
     * find last sama lah pokoknya
     *
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

    fun execute(nums: IntArray, target: Int): IntArray {
        var startIndex = 0
        var lastIndex = nums.size - 1
        var first = -1
        var last = -1
        var isFound = false

        // find first
        while(isFound == false && startIndex <= lastIndex){
            var midle = startIndex + ((lastIndex - startIndex))/2
            var values = nums[midle]

            if(values == target){
                if(midle == 0){
                    isFound = true
                    first = midle
                    continue
                }
                var firstData = nums[midle-1]
                if(firstData != target){
                    isFound = true
                    first = midle
                }else{
                    lastIndex = midle - 1
                }
            }else if(values < target){
                startIndex = midle + 1
            }else{
                lastIndex = midle - 1
            }
        }

        startIndex = 0
        lastIndex = nums.size - 1
        isFound = false

        // find last
        while(isFound == false && startIndex <= lastIndex){
            var midle = startIndex + (lastIndex - startIndex)/2
            var values =  nums[midle]

            if(values == target){
                if(midle == nums.size-1){
                    last = midle
                    isFound = true
                    continue
                }
                var lastData = nums[midle+1]
                if(lastData != target){
                    isFound = true
                    last = midle
                }else{
                    startIndex = midle + 1
                }
            }else if(values < target){
                startIndex = midle + 1
            }else{
                lastIndex = midle - 1
            }
        }

        return intArrayOf(first,last)
    }

}