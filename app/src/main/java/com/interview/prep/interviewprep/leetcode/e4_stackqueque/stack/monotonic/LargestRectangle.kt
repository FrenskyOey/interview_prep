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
     * jadi di dalam stacknya kita bakal menyimpan indexnya mulai dari index 0 sata index n-1
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
     * i1 insert 2 -> stack[{0|2}] -> menyimpan nilai index dan height
     * currentMax = 0
     *
     * i2 insert 1 lebih kecil dari 2.. terjadi breaking point sehingga kita mulai hitung tinggi maksimum si data 2
     * luas maksimumnya adalah = 2 * (index(1)1-0(index(2))) = 2*1 = 2
     * nah untuk index dari 1 kita buat jadi 0, ini karena kita mencari width terpanjang dimana 1 itu bagian dari 2
     * makanya index height 2 menjadi index height 1
     * stack[{0|1}]
     * currentMax = 2
     *
     * i3 insert 5 -> aman karena 5>2
     * stack[{0|1},{2|5}]
     * currentMax = 2
     *
     * i4 insert 6 -> aman karena 6>5
     * stack[{0|1},{2|5},{3|6}]
     * currentMax = 2
     *
     * i5 insert 2 -> breaking karena 2<6
     * terjadi pop sampai height 5, di sini kita akan simpan index 5 sebagai bagian height 2, jadi bukan simpan 4 melainkan 2
     * stack[{0|1},{2|5}]
     * curentMax = 6 (dari 6 * (4-3))

     * stack[{0|1}]
     * currentMax = 10 (dari 5 * (4-2))
     * stack[{0|1},{2|2}]
     *
     * i6 insert 3 -> aman karena 3 > 2
     * stack[{0|1},{2|2},{5|3}]
     *
     * i7 habis... pas habis kita coba cari luas dari sisa stack yang masih tersisa dengan rumus
     * (i7 - index) * height
     * (6 - 5) * 3 = 3
     * (6 - 2) * 2 = 8
     * (6 - 0) * 1 = 6
     * currentMax = 10
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