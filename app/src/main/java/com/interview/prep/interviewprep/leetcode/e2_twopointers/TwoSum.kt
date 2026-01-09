package com.interview.prep.interviewprep.leetcode.e2_twopointers

/**
 * ==========================================
 * PROBLEM: 167. Two Sum II - Input Array Is Sorted
 * ==========================================
 *
 * URL: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * DESCRIPTION:
 *
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 *
 * Example 1:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * Example 2:
 *
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * Example 3:
 *
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 *
 *
 * Constraints:
 *
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 *
 */

class TwoSum {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Two Pointer
     *
     * Strategy:
     *
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     *
     * di sini kita bisa kasih 2 pointer, ujung kiri dan kanan.. karena sudah tersorting datanya.. maka kita bisa langsung aja pake mekanisme
     * dimana data pointer 1 + data pointer 2 itu hasilnya apa lebih besar atau lebih kecil dari target, kalau misalkan lebih besar maka pointer kanan bakal mundur
     * kalau lebih kecil maka pointer kiri yang maju
     *
     *   >>2 7 11 >>15  2 + 15 = 17 lebih besar dari 9 maka pointer kanan mundur
     *   >>2 7 >>11 15 2 + 11 = 13 lebih besar dari 9 maka pointer kanan mundur
     *   >>2 >>7 11 15 2 + 7 = 9 hasilnya sama maka jawabannya = 0,1
     *
     * Complexity Analysis: O(n)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(numbers: IntArray, target: Int): IntArray {
        var pointer1 = 0
        var pointer2 = numbers.size - 1
        var isFound = false

        while(isFound == false && pointer2 > pointer1){
            val total = numbers[pointer1] + numbers[pointer2]
            if(total == target){
                isFound = true
                continue
            }else if(total > target){
                pointer2 = pointer2 - 1
            }else{
                pointer1 = pointer1 + 1
            }
        }

        if(isFound){
            return intArrayOf(pointer1+1,pointer2+1)
        }else{
            return intArrayOf(0,0)
        }
    }

}