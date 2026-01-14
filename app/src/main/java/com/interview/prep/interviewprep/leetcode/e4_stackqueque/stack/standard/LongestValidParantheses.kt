package com.interview.prep.interviewprep.leetcode.e4_stackqueque.stack.standard

/**
 * ==========================================
 * PROBLEM: 32. Longest Valid Parentheses
 * ==========================================
 * HARD
 * URL: https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * DESCRIPTION:
 *
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 *
 */

class LongestValidParantheses {
    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Stack
     *
     * Kunci utama menyelesaikan soal ini dengan Stack adalah: jangan simpan karakternya, tapi simpan indeks-nya.
     * Kita butuh angka -1 sebagai "jangkar" awal untuk menghitung panjang jika tanda kurung valid dimulai dari indeks 0.
     *
     * Isi Stack: Angka di dalam sini adalah indeks. Angka terakhir di dalam kurung [] adalah yang kita gunakan sebagai pengurang.
     * Aksi Pop: Setiap kali ketemu ), kita wajib buang satu elemen dari stack.
     * Jangkar (Anchor): Perhatikan langkah 1, ketika ) muncul di awal, dia menggantikan -1 menjadi 0.
     * Ini artinya semua perhitungan valid berikutnya akan dimulai setelah indeks 0.
     *
     * INPUT: ")()()"
     *
     * Step | Char | i | Action            | Stack    | Length Calc | Max
     * --------------------------------------------------------------------
     * Init | -    | - | Push -1           | [-1]     | -           | 0
     * 1    | )    | 0 | Pop -1, Push 0    | [0]      | -           | 0
     * 2    | (    | 1 | Push 1            | [0, 1]   | -           | 0
     * 3    | )    | 2 | Pop 1, Calc(2-0)  | [0]      | 2           | 2
     * 4    | (    | 3 | Push 3            | [0, 3]   | -           | 2
     * 5    | )    | 4 | Pop 3, Calc(4-0)  | [0]      | 4           | 4
     *
     * HASIL AKHIR: 4
     *
     *
     *
     * Contoh Soal:
     *
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(s: String): Int {
        var maxCounter = 0
        var stacks : ArrayDeque<Int> = ArrayDeque()
        var indexes = 0
        stacks.addFirst(-1)

        for(char in s){
            when{
                char == '(' -> {
                    stacks.addFirst(indexes)
                }
                char == ')' ->{
                    stacks.removeFirstOrNull()
                    if (stacks.isEmpty()) {
                        stacks.addFirst(indexes)
                    } else {
                        maxCounter = Math.max(maxCounter, indexes - stacks.first());
                    }
                }
            }
            indexes = indexes + 1
        }
        return maxCounter
    }
}