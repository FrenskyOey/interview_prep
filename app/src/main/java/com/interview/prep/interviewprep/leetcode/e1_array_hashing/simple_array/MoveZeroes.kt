package com.interview.prep.interviewprep.leetcode.e1_array_hashing.simple_array
/**
 *  * Estimation time arround 20 minute
 * ==========================================
 * PROBLEM: 283. Move Zeroes
 * ==========================================
 *
 * URL:https://leetcode.com/problems/move-zeroes/description/
 *
 * Easy
 * DESCRIPTION:
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 */

class MoveZeroes {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Array
     *
     * Strategy:
     * jadi tahapan gambarannya kaya gini
     * Example 1
     * [0,1,0,3,12]
     * -- iterasi 0
     * lastValueIndex = 0
     * i = 0
     * value = 0
     * di cek apa si elemen 0 atau bukan kalau bukan 0 maka kita proses kalau nga skip di sini 0 maka kita skip
     *
     * -- iterasi 1
     * lastValueIndex = 0
     * i = 1
     * value = 1
     * di sini nilainya bukan 0 maka kita geser kita nilai lastValue Index dan ubah si array[i] jadi 0
     * array[1] = 0
     * array[lastValueIndex] = value -> array[0] = 1

     * lastValueIndex = lastValueIndex + 1 = 1
     * [1,0,0,3,12]
     *
     * -- iterasi 2
     * lastValueIndex = 1
     * i = 2
     * value = 0
     * skip
     *
     * -- iterasi 3
     * lastValueIndex = 1
     * i = 3
     * value = 3
     * di sini nilainya bukan 0 maka kita geser kita nilai lastValue Index dan ubah si array[i] jadi 0
     * array[3] = 0
     * array[lastValueIndex] = value -> array[1] = 3
     * lastValueIndex = lastValueIndex + 1 = 2
     * [1,3,0,0,12]
     *
     * -- iterasi 4
     * lastValueIndex = 2
     * i = 4
     * value = 12
     * di sini nilainya bukan 0 maka kita geser kita nilai lastValue Index dan ubah si array[i] jadi 0
     * array[4] = 0
     * array[lastValueIndex] = value -> array[2] = 12
     * lastValueIndex = lastValueIndex + 1 = 3
     * [1,3,12,0,0]
     *
     * -- finish --
     *
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

    fun execute(data : IntArray): IntArray {
        var lastValueIndex = 0
        var indexes = 0
        for(element in data){
            if(element == 0){
                indexes++
                continue
            }
            data[indexes] = 0
            data[lastValueIndex] = element
            lastValueIndex++
            indexes++
        }
        return data
    }

}