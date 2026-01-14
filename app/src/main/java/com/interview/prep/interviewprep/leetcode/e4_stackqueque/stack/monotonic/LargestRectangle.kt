package com.interview.prep.interviewprep.leetcode.e4_stackqueque.stack.monotonic
/**
 * ==========================================
 * PROBLEM: 84. Largest Rectangle in Histogram
 * ==========================================
 *
 * URL:https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * HARD
 * DESCRIPTION:
 *
 *
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 *
 * Example 1:
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 *
 *
 * Example 2:
 *
 * Input: heights = [2,4]
 * Output: 4
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 *
 */

class LargestRectangle {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Monotonic Stack
     *
     * Input: heights = [2,1,5,6,2,3]
     * Output: 10
     * Explanation: The above is a histogram where width of each bar is 1.
     * The largest rectangle is shown in the red area, which has an area = 10 units.
     *
     * untuk resolve ini cara paling enak itu pakai monotonic stack
     * jadi di dalam stacknya kita bakal menyimpan indexnya mulai dari index 1 sata index n
     * aturan monotonicnya adalah ketika nilai baru yang disimpan lebih kecil dari nilai terakhir,
     * maka kita harus mencari nilai luas kotak terakhir dengan cara nilai height * jarak index kotak terakhir sama kotak target kita
     * karena di sini kita mencari kemungkinan width terpanjang dari suatu histogram yang bakal patah kalau histogram berikutnya itu lebih pendek dari tingginya dia
     *
     * berikut simulasinya
     * initial
     * [2,1,5,6,2,3]
     * currentMax = 0
     * stack []
     *
     * i1 insert 2 -> stack[1] -> menyimpan nilai index
     * currentMax = 0
     *
     * i2 insert 1 lebih kecil dari 2.. terjadi breaking point sehingga kita mulai hitung tinggi maksimum si data 2
     * luas maksimumnya adalah = 2 * (index(1)2-1(index(2))) = 2*1 = 2
     * stack[1] -> kita ambil nilai terujung dari 1 karena 2 juga bagian dari 1
     * currentMax = 2
     *
     * i3 insert 5 -> aman karena 5>2
     * stack[2,3]
     * currentMax = 2
     *
     * i4 insert 6 -> aman karena 6>5
     * stack[2,3,4]
     * currentMax = 2
     *
     * i5 insert 2 -> breaking karena 2<6
     * terjadi pop sampai index 2
     * stack[2,3]
     * curentMax = 6 (dari 6 * (5-4))
     * stack[2]
     * currentMax = 10 (dari 5 * (5-3))
     * stack[2,5]
     *
     * hashmap {2:1,5:2}
     *
     * i6 insert 3 -> aman karena 3 > 2
     * stack [2,5,6]
     *
     *
     * Complexity Analysis: O(n)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(heights: IntArray): Int {
        val stack : ArrayDeque<Int> = ArrayDeque()
        var currentMax = 0
        var indexes = 0

        for(height in heights){
            if(stack.isEmpty()){
                stack.addFirst(indexes)
                indexes = indexes + 1
                continue
            }

            var values = heights[stack.first()]
            if(values < height){
                stack.addFirst(indexes)
            }else if(values == height){
                // skip
            }else{//popping happens
                var isFounds = false
                var heightIndexes = indexes
                while(isFounds == false && values > height){
                    heightIndexes = stack.removeFirst()
                    val area = heights[heightIndexes] * (indexes - heightIndexes)
                    if(currentMax < area){
                        currentMax = area
                    }
                    if(stack.isEmpty()){
                        isFounds = true
                        continue
                    }
                    values = heights[stack.first()]
                }
                heights[heightIndexes] = height
                stack.addFirst(heightIndexes)
            }
            indexes = indexes + 1
        }

        while(!stack.isEmpty()){
            var heightIndexes = stack.removeFirst()
            val area = heights[heightIndexes] * (indexes - heightIndexes)
            if(currentMax < area){
                currentMax = area
            }
        }

        return currentMax
    }

}