package com.interview.prep.interviewprep.leetcode.e1_array_hashing.hashmap


/**
 * ==========================================
 * PROBLEM: 128. Longest Consecutive Sequence
 * ==========================================
 *
 * URL:https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * DESCRIPTION:
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * Example 3:
 *
 * Input: nums = [1,0,1,2]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 */

class LongestConsquetive {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Hashmap
     *
     * Strategy:
     *
     * Input: nums = [100,4,200,1,3,2]
     *  * Output: 4
     *  * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     *
     * pendekatananya pertama kita masukin semua dulu ke hashmap dengan nilai true
     * h[100] = true
     * h[4] = true
     * h[200] = true
     * h[1] = true
     * h[3] = true
     * h[2] = true
     *
     * setelah kita masukin ke set, kita baru mulai pengecekan countrernya pakai for nums dengan mengecek kondisi dulu apakah si entity yang kita masukin adalah awal dari sequnce atau bukan
     *
     * input 100 : cek apa ada hash[99].. rupanya nga ada.. artinya dia awal dari sequence
     *
     * karena dia awal sequence selanjutnya kita cek jumlah counter sequencenya dengan mengecek kondisi sesudahnya apa ada di hash atau tidak kalau tidak ada makan counternya langsung 1
     * cek hash[101] nga nemu maka langsung counter = 1
     *
     * input 4 : cek rupanya ada hash[3] maka kita bisa skip karena bukan nilai awal
     *
     * input 200 : cek apa ada hash [199].. rupanya nga ada.. artinya dia awal dari sequence
     * cek nga ada hash [201] berarti counter = 1
     *
     * input 1 : cek apa ada hash [0].. rupanya nga ada.. artinya dia awal dari sequence
     * cek hash[2] ada berarti conunter + 1 = 2
     * cek hash[3] ada berarti counter + 1 = 3
     * cek hash[4] ada berarti counter +1 = 4
     * cek hash[5] nga ada berarti counternya stop di 4
     *
     * input 3 : cek rupanya ada hash[2] maka kita bisa skip karena bukan nilai awal
     * input 2 : cek rupanya ada hash[1] maka kita bisa skip karena bukan nilai awal
     *
     * resultnya adalah 4 sebagai terpanjang
     *
     * Algorithm
     *
     * Solusinya buat object class isinya counter dan juga boolean hasTail, kalau hasTail true maka ketika ada data baru dia akan kehapus
     * intinya kalau mislakan si nilai input > dari nilai hashmap, maka nilai hashmap akan auto hapus
     *
     *
     * Complexity Analysis:
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(nums: IntArray): Int {
        var max = 0
        var hash : HashMap<Int, Boolean> = hashMapOf()
        var results : HashMap<Int, Int> = hashMapOf()
        //filling hashmap data
        for(entity in nums){
            hash[entity] = true
        }

        for(data in nums){
            // skip if its not the first sequences
            if(hash.contains(data-1)){
                continue
            }

            //skip if its already added
            if(results.contains(data)){
                continue
            }

            var shouldStop = false
            var counter = 0
            var indexes = data
            while(!shouldStop){
                if(hash.contains(indexes)){
                    counter = counter + 1
                }else{
                    shouldStop = true
                }
                indexes = indexes + 1
            }

            results[data] = counter

            if(max < counter){
                max = counter
            }
        }
        return max
    }

}