package com.interview.prep.interviewprep.leetcode.e4_stackqueque.stack.monotonic

import android.icu.text.NumberFormat

/**
 * ==========================================
 * PROBLEM: 402. Remove K Digits
 * ==========================================
 *
 * URL:https://leetcode.com/problems/remove-k-digits/description/
 *
 * DESCRIPTION:
 *
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 *
 *
 *
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 *
 * Constraints:
 *
 * 1 <= k <= num.length <= 105
 * num consists of only digits.
 * num does not have any leading zeros except for the zero itself.
 *
 */

class RemoveKDigits {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Monotonic Stack
     *
     * Strategy:
     * Input: num = "1432219", k = 3
     * Output: "1219"
     * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
     *
     * Masalah ini bisa di solve dengan gampang menggunakan monotonic stack, jadi di dalam stack kita hanya menstore angka yang lebih kecil
     * kalau angka yang dimasukkan lebih besar dari yang dulu, kita simpan, tapi kalau misalkan angka yang dimasukkan lebih kecil, maka angka yang lebih besarnya
     * harus di pop. Jadi tujuannya di sini tuh ngepop angka paling besar dari yang paling gede digitnya
     * Tapi ingat, kita harus mengikuti aturan K
     * Jika pada akhirnya si stack masih bersisa, maka bakal kita pop sampai counter k habis, karena harusnya angka paling kecil itu ada di paling belakang
     *
     * simulasi
     *
     * i1 >1432219
     * stack = 1
     * k = 3
     *
     * i2 1>432219
     * 4 > dari 1 jadi masih kita masukin ke stack
     * stack = 1,4
     * k =3
     *
     * i3 14>32219
     * 3 < 4 di sini kita pop 4
     * stack = 1
     * k = 2
     * di sini 3 > 1 maka masukin ke stack
     * stack = 1,3
     *
     * i4 143>2219
     *  2 < 3 di sini kita pop 3
     *  stack = 1
     *  k = 1
     *  di sini 2 > 1 maka masukin stack
     *  stack = 1,2
     *
     * i5 1432>219
     * 2 <=2 di sini kita bisa pop 2
     * stack = 1
     * k = 0
     * di sini 2 > 1 maka masukin stack
     * stack = 1,2
     *
     * i6 14322>19
     * k sudah habis auto masukin stack
     * stack = 1,2,1
     *
     * i7 143221>9
     * k sudah habis auto masukin stack
     * stack = 1,2,1,9
     *
     * jawaban 1219
     *
     * Complexity Analysis: O(n)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(num: String, k: Int): String {
        val stack = ArrayDeque<Int>()
        var counter = k

        // filling monotonic stack
        for(number in num){
            val numb = number.digitToInt()
            if(stack.isEmpty()){
                stack.addFirst(numb)
                continue
            }
            var peek = stack.first()
            var shouldStop = false

            while(shouldStop == false && peek > numb && counter > 0){
                stack.removeFirstOrNull()
                counter = counter - 1
                if(stack.isEmpty()){
                    shouldStop = true
                    continue
                }
                peek = stack.first()
            }
            stack.addFirst(numb)
        }

        // remove remaining bug number starting from ends, until counter equals to 0
        while(counter > 0 && !stack.isEmpty()){
            stack.removeFirstOrNull()
            counter = counter - 1
        }

        // remove 0 at front sample case "000200 to 200"
        while(!stack.isEmpty() && stack.last() == 0){
            stack.removeLastOrNull()
        }

        if(stack.isEmpty()){
            return "0"
        }else{
            return stack.reversed().joinToString("")
        }
    }
}