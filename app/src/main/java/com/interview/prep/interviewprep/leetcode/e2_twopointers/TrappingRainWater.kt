package com.interview.prep.interviewprep.leetcode.e2_twopointers

/**
 * ==========================================
 * PROBLEM: 42. Trapping Rain Water
 * ==========================================
 *
 * URL: https://leetcode.com/problems/trapping-rain-water/description/
 * Hard
 *
 * DESCRIPTION:
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Example 1:
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 */

class TrappingRainWater {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Two Pointer
     *
     * Strategy:
     *
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     *
     * Untuk solving masalah ini kita harus tau dulu mekanisme cara menghitung air pada arraynya
     * jadi si volume air itu di dapat dari apitan antara tinggi kiri dan juga kanan
     * contohnya 1,0,2
     * di sini kita liat kalau air yang di dapat itu 1 di dapat dari nilai tengah 0 dengan rumus tinggi yang lebih tinggi - tinggi yang lebih rendah - current data
     * berarti
     *  1 - 0 = 1
     *
     *  contoh berikutnya 2,1,0,1,3
     *  kita mulai dari 2.. karena dia paling ujung ya nga ada volume maka = 0
     *  1 -> karena lebih kecil dari 2 maka volume yang di dapat adalah 2-1 = 1
     *  0 -> lebih kecil dari 2 maka volumenya = 2- 0 = 2
     *  1 -> lebih kecil dari 2 maka volumenya = 2 - 1 = 1
     *  3 -> lebih gede dari 2 maka kita ganti pointer maksimum baru ke 3
     *
     *  nah cuman bakal ada kendala kalau datanya seperti ini
     *  contoh 3,2,1,2
     *  kendala kalau data awalnya itu adalah yang paling maksimum kalau pakai algo lama hasilnya adalah 4 padahal harusnya cuman 1
     *
     *  untuk handling masalah itu maka kita harus pakai 2 pointer satu ujung kiri satu lagi ujung kanan
     *  anggap datanya kita ubah jadi gini
     *
     *  >2,1,0,1,3,2,1,>2
     *  tinggi max kiri : 2
     *  tinggi max kanan : 2
     *  nilai kiri : 2
     *  nilai kanan : 2
     *  vol : 0
     *  ini karena masih data awal maka hasilnya masih 0 -> (2-2) + (2-2) = 0
     *  kita bandingin rupanya nilai kiri dan kanan sama maka kita majuin dulu aja pointer kiri
     *
     *  2, >1, 0, 1, 3, 2, 1, >2
     *  tinggi max kiri : 2
     *  tinggi max kanan : 2
     *  nilai kiri : 1
     *  nilai kanan : 2
     *  vol += tinggi max kiri - nilai kiri =  2-1 += 1
     *  karena nilai kiri masih lebih kecil dari nilai kanan maka kita masih majuin pointer kiri
     *
     *  2, 1, >0, 1, 3, 2, 1, >2
     *  tinggi max kiri : 2
     *  tinggi max kanan : 2
     *  nilai kiri : 0
     *  nilai kanan : 2
     *  vol += tinggi max kiri - nilai kiri =  2-0 += 2 = 3
     *  karena nilai kiri masih lebih kecil dari nilai kanan maka kita masih majuin pointer kiri
     *
     *  2, 1, 0, >1, 3, 2, 1, >2
     *  tinggi max kiri : 2
     *  tinggi max kanan : 2
     *  nilai kiri : 1
     *  nilai kanan : 2
     *  vol += tinggi max kiri - nilai kiri =  2-1 += 1 = 4
     *  karena nilai kiri masih lebih kecil dari nilai kanan maka kita masih majuin pointer kiri
     *
     *  2, 1, 0, 1, >3, 2, 1, >2
     *  tinggi max kiri : 2
     *  tinggi max kanan : 2
     *  nilai kiri : 3
     *  nilai kanan : 2
     *  karena nilai 3 lebih besar dari max kiri maka nilai max kiri kita update ke 3 dan karena nilai kanan lebih kecil dari nilai kiri maka yang pointer kanan update ke kanan-1
     *
     *  2, 1, 0, 1, >3, 2, >1, 2
     *  tinggi max kiri : 3
     *  tinggi max kanan : 2
     *  nilai kiri : 3
     *  nilai kanan : 1
     *  vol += tinggi max kanan - nilai kanan =  2-1 += 1 = 5
     *  karena nilai kanan masih lebih kecil dari nilai kiri maka kita masih mundurin pointer kanan
     *
     *  2, 1, 0, 1, >3, >2, 1, 2
     *  tinggi max kiri : 3
     *  tinggi max kanan : 2
     *  nilai kiri : 3
     *  nilai kanan : 2
     *  vol += tinggi max kanan - nilai kanan =  2-2 += 0 = 5
     *  karena nilai kanan masih lebih kecil dari nilai kiri maka kita masih mundurin pointer kanan
     *
     *
     *  si pointer kiri dan kanan ketemu, stop iterasi, resultnya adalah 5
     *
     *
     * Complexity Analysis: O(n)
     * Complexity Memory : O(1)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(height: IntArray): Int {
        if(height.isEmpty()){
            return 0
        }
        var pointerRight = height.size-1
        var pointerLeft = 0
        var maxRight = height[height.size-1]
        var maxLeft = height[0]

        var volume = 0

        while(pointerLeft < pointerRight){
            val heightLeft = height[pointerLeft]
            val heightRight = height[pointerRight]

            if(heightLeft <= heightRight){
                if(heightLeft > maxLeft){
                    maxLeft = heightLeft
                }else{
                    volume += (maxLeft - heightLeft)
                }
                pointerLeft = pointerLeft + 1
            }else{
                if(heightRight > maxRight){
                    maxRight = heightRight
                }else{
                    volume += (maxRight - heightRight)
                }
                pointerRight = pointerRight - 1
            }
        }

        return volume
    }

}