package com.interview.prep.interviewprep.leetcode.e1_array_hashing.simple_array
/**
 * Estimation time arround 20 minute
 * ==========================================
 * PROBLEM: 122. Best Time to Buy and Sell Stock II
 * ==========================================
 *
 * URL:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * DESCRIPTION:
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.
 *
 * Find and return the maximum profit you can achieve.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 *
 */

class BestStock2 {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Array
     *
     * Strategy:
     * // Ini bisa pake greedy intinya adalah jika besok untung maka kita belu hari ini dan jual besok, untung sedikit saja ya kita ambil
     * kasus 1
     * [7,1,5,3,6,4]
     * hari pertama dan kedua terjadi penurunan.. kita skip
     * hari kedua dan ketiga ada untung dari 1 ke 5 sebesar 4 koin kita ambil dan keuntungan sudah 4
     * hari ketiga dan kempat terjadi penurunan kita skip
     * hari keempat dan kelima ada untung dari 3 ke 6 di sini kita ambil dan keuntungan bertambah 3 = 7
     * hari kelima dan keenam terjadi penurunan kita skip
     *
     * Output = 7
     *
     * kasus 2
     * [1,2,3,4,5]
     * hari pertama dan kedua ada untung kita ambil laba = 1
     * hari 2 dan 3 ada untung kita mabil laba = 1 + 1 = 2
     * hari 3 dan 4 ada untung kita ambil laba = 2 + 1 = 3
     * hari 4 dan 5 ada untung kita ambil laba = 3 + 1 = 4
     *
     * Ouput = 4
     *
     * kasus 3
     * [7,6,4,3,1]
     * ga ada keuntungan di hari apapun jadinya laba = 0
     *
     * kelemahan greedy belum tentu ya hasilnya optimal, kalau mau optimal mungkin bisa diimprove menggunakan kadane algorithm, but kita coba dulu deh algonya
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

    fun execute(data : IntArray): Int {
        var profits = 0
        var nextIndexes = 0
        val maxSize = data.size - 1
        for(value in data){
            if(nextIndexes < maxSize){
                nextIndexes = nextIndexes + 1
            }
            var nextValue = data[nextIndexes]

            if(value < nextValue){
                profits += nextValue - value
            }
        }
        return profits
    }

}