package com.interview.prep.interviewprep.leetcode.e1_array_hashing.prefixsum


/**
 * ==========================================
 * PROBLEM: 560. Subarray Sum Equals K
 * ==========================================
 *
 * URL: https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * DESCRIPTION:
 *
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 */


class SubArraySumK {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Prefix Sum + Hashmap
     *
     * Strategy:
     *
     * misalkan ada array
     * [1,2,3,4,5] k =5
     *
     * nah presumnya akan seperti ini kira kira
     * [1,3,6,10,15] k = 5
     *
     *
     * 1. KONSEP DASAR
     *    Untuk mencari jumlah subarray yang bernilai K secara efisien (O(n)),
     *    kita menggunakan logika selisih Prefix Sum (Presum).
     *
     * 2. LOGIKA MATEMATIKA
     *    Rumus jumlah subarray di antara dua titik:
     *    K = Presum(akhir) - Presum(awal - 1)
     *
     *    Karena kita mencari titik awal yang cocok, rumusnya dibalik menjadi:
     *    Presum(awal - 1) = Presum(akhir) - K
     *
     *    Artinya: "Jika (Total Saat Ini - K) pernah muncul di masa lalu,
     *    maka jarak di antaranya pasti bernilai K."
     *
     * 3. KENAPA PAKAI HASHMAP?
     *    - Untuk menyimpan "History" nilai Presum yang sudah lewat.
     *    - Karena ada angka NEGATIF, nilai Presum bisa muncul berulang kali.
     *    - HashMap menyimpan counter
     *
     * 4. LANGKAH-LANGKAH (STEPS)
     *    A. Inisialisasi HashMap dengan {0:1}. (Penting untuk case Presum == K).
     *    B. Iterasi array, update Current_Sum.
     *    C. Cari (Current_Sum - K) di dalam HashMap.
     *    D. Jika ketemu, tambahkan FREKUENSI-nya ke total hasil.
     *    E. Simpan Current_Sum ke HashMap (tambah frekuensinya jika sudah ada)
     *
     * Sample 1
     * [1,2,3,4,5] k = 5
     * ================================================================
     * STEP | NUM | SUM | SEARCH (SUM-K) | FOUND? | TOTAL | MAP STATE
     * ================================================================
     * Init |  -  |  0  |      -         |   -    |   0   | {0:1}
     * ----------------------------------------------------------------
     * 1.   |  1  |  1  |  1 - 5 = -4    |   No   |   0   | {0:1, 1:1}
     * ----------------------------------------------------------------
     * 2.   |  2  |  3  |  3 - 5 = -2    |   No   |   0   | {0:1, 1:1, 3:1}
     * ----------------------------------------------------------------
     * 3.   |  3  |  6  |  6 - 5 =  1    | YES(1) |   1   | {..., 3:1, 6:1}
     * ----------------------------------------------------------------
     * 4.   |  4  | 10  | 10 - 5 =  5    |   No   |   1   | {..., 6:1, 10:1}
     * ----------------------------------------------------------------
     * 5.   |  5  | 15  | 15 - 5 = 10    | YES(1) |   2   | {..., 10:1, 15:1}
     * ================================================================
     * FINAL RESULT: 2
     * ================================================================
     *
     * Sample 2
     * [1, -1, 1, -1] | k = 0
     *  ================================================================
     * STEP | NUM | SUM | SEARCH (SUM-K) | FOUND? | TOTAL | MAP STATE
     * ================================================================
     * Init |  -  |  0  |      -         |   -    |   0   | {0:1}
     * ----------------------------------------------------------------
     * 1.   |  1  |  1  |  1 - 0 =  1    |   No   |   0   | {0:1, 1:1}
     * ----------------------------------------------------------------
     * 2.   | -1  |  0  |  0 - 0 =  0    | YES(1) |   1   | {0:2, 1:1}
     * ----------------------------------------------------------------
     * 3.   |  1  |  1  |  1 - 0 =  1    | YES(1) |   2   | {0:2, 1:2}
     * ----------------------------------------------------------------
     * 4.   | -1  |  0  |  0 - 0 =  0    | YES(2) |   4   | {0:3, 1:2}
     * ================================================================
     * FINAL RESULT: 4
     * ================================================================
     *
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

    fun execute(nums: IntArray, k: Int): Int {
        val hashmap : HashMap<Int,Int> = hashMapOf()
        var currentSum = 0
        hashmap[0] = 1

        var counter = 0
        for(data in nums){
            currentSum = currentSum + data
            val targets = currentSum - k
            if(hashmap.contains(targets)){
                counter = counter + (hashmap[targets]?:0)
            }

            var counterLocal = hashmap[currentSum] ?: 0
            counterLocal = counterLocal + 1
            hashmap[currentSum] = counterLocal
        }
        return counter
    }
}