package com.interview.prep.interviewprep.leetcode.e4_stackqueque.stack.monotonic
/**
 * ==========================================
 * PROBLEM: 739. Daily Temperatures
 * ==========================================
 *
 * URL:https://leetcode.com/problems/daily-temperatures/description/
 *
 * DESCRIPTION:
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 *
 */

class DailyTemperatures {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Monotonic Stack
     *
     * Strategy:
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     * Example 2:
     *
     * untuk solve masalah ini kita bakal gunain monotonic stack, but instead nilai temperatur, kita simpennya mending index
     * kita simpan, gunanya agar bisa kita cari jaraknya yang akan di simpan di output
     * dan kedua adalah monotonic stack dimana nilai yang kita masukkan adalah dari gede ke kecil, dari kalau nemu angka gede. yang kecil akan
     * di pop satu satu
     *
     * nanti pas di pop itu baru kita masukin penghitungannya ke output seperti ini simulasinya
     *
     * // stack menyimpan index
     *
     * [73,74,75,71,69,72,76,73]
     * stack []
     * hashmap {}
     * output []
     *
     * i1 73
     * stack [0]
     * hashmap{0:73}
     * output [0,0,0,0,0,0,0,0]
     *
     * i2 74
     * value hashmap[0] = 73
     * karena nilai 74 itu lebih gede dari 73 maka kita bakal pop nilai stacknya
     * stack [1]
     * array{0:73,1:74,2:75,3:71,4:69,5:72,6:76,7:73}
     * output [1,0,0,0,0,0,0,0]{dari 1-0}
     *
     * i3 75
     * karena nilai 74 itu lebih gede dari 73 maka kita bakal pop nilai stacknya
     * stack [2]
     * array{0:73,1:74,2:75,3:71,4:69,5:72,6:76,7:73}
     * output [1,1,0,0,0,0,0,0]{dari 2-1}
     *
     * i4 71
     * stack [2,3]
     * array{0:73,1:74,2:75,3:71,4:69,5:72,6:76,7:73}
     * output [1,1,0,0,0,0,0,0]
     *
     * i5 69
     * stack [2,3,4]
     * array{0:73,1:74,2:75,3:71,4:69,5:72,6:76,7:73}
     * output [1,1,0,0,0,0,0,0]
     *
     * i6 72
     * 71 dan 69 bakal ke pop karena lebih kecil dari 72 dan nilai selisih akan langsung dimasukkan ke output
     * stack [2,5]
     * array{0:73,1:74,2:75,3:71,4:69,5:72,6:76,7:73}
     * output [1,1,0,2,1,0,0,0]
     *
     * i7 76
     * 72 dan 75 bakal ke pop karena lebih kecil dari 76 dan nilai selisih akan langsung dimasukkan ke output
     * stack [6]
     * array{0:73,1:74,2:75,3:71,4:69,5:72,6:76,7:73}
     * output [1,1,4,2,1,1,0,0]
     *
     * i8 73
     * masuk stack
     * stack [6,7]
     * array{0:73,1:74,2:75,3:71,4:69,5:72,6:76,7:73}
     * output [1,1,4,2,1,1,0,0]
     *
     *
     * Complexity Analysis: O(n)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(temperatures: IntArray): IntArray {
        var result = IntArray(temperatures.size)
        result.fill(0)
        var stacks : ArrayDeque<Int> = ArrayDeque()
        var indexes = 0

        for(temp in temperatures){
            var valuePeek : Int? = null
            if(!stacks.isEmpty()){
                valuePeek = temperatures[stacks.first()]
            }

            if(valuePeek == null || temp <= valuePeek){
                stacks.addFirst(indexes)
            }else{
                var shouldStop = false
                while(shouldStop == false && temp > valuePeek!!){
                    val index = stacks.removeFirst()
                    val distances = indexes - index
                    result[index] = distances

                    if(stacks.isEmpty()){
                        shouldStop = true
                        continue
                    }
                    valuePeek = temperatures[stacks.first()]
                }
                stacks.addFirst(indexes)
            }
            indexes = indexes + 1
        }
        return result
    }

}