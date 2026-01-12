package com.interview.prep.interviewprep.leetcode.e3_slidingwindow.dynamic

/**
 * ==========================================
 * PROBLEM: 2743. CountSubstringChar
 * ==========================================
 *
 * URL: https://github.com/doocs/leetcode/blob/main/solution/2700-2799/2743.Count%20Substrings%20Without%20Repeating%20Character/README_EN.md
 *
 * DESCRIPTION:
 *
 * You are given a string s consisting only of lowercase English letters. We call a substring special if it contains no character which has occurred at least twice (in other words, it does not contain a repeating character). Your task is to count the number of special substrings. For example, in the string "pop", the substring "po" is a special substring, however, "pop" is not special (since 'p' has occurred twice).
 *
 * Return the number of special substrings.
 *
 * A substring is a contiguous sequence of characters within a string. For example, "abc" is a substring of "abcd", but "acd" is not.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcd"
 * Output: 10
 * Explanation: Since each character occurs once, every substring is a special substring. We have 4 substrings of length one, 3 of length two, 2 of length three, and 1 substring of length four. So overall there are 4 + 3 + 2 + 1 = 10 special substrings.
 * Example 2:
 *
 * Input: s = "ooo"
 * Output: 3
 * Explanation: Any substring with a length of at least two contains a repeating character. So we have to count the number of substrings of length one, which is 3.
 * Example 3:
 *
 * Input: s = "abab"
 * Output: 7
 * Explanation: Special substrings are as follows (sorted by their start positions):
 * Special substrings of length 1: "a", "b", "a", "b"
 * Special substrings of length 2: "ab", "ba", "ab"
 * And it can be shown that there are no special substrings with a length of at least three. So the answer would be 4 + 3 = 7.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters
 *
 *
 */

class CountSubstringChar {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: sliding windows + hashmap
     *
     * Strategy:
     *
     * Input: s = "abab"
     * Output: 7
     * Explanation:
        "a","b","a","b","ab","ba","ab"

        kita mulai dari hal kecil dulu dari aba {pake sliding window}

        a = 1
        ab = 1 + "b" + "ab" = 1 + 2 = 3
        aba... breaking kita majuin anya
        ba = 3 + "a" + "ba" = 3 + 2 = 5
        bab... breaking kita majuin bnya
        ab = 5 + "b" + "ab" = 5 + 2 = 7

        apa jadinya kalau abcd
        a = 1
        ab = 1 + "b" + "ab" = 1 + 2 = 3
        abc = 3 + "c" + "bc" + "abc" = 3 + 3 = 6

     jadi rumusnya adalah counter += string length

     untuk ini pakai sliding windows. kalau sliding windowsnya aman maka si pointer kanan maju, kalau rusak maka pointer kiri akan maju sampe valid
     *
     * Algorithm
     *
     * Complexity Analysis: O (N)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(s: String): Int {
        var hashmap : HashMap<Char,Int> = hashMapOf()
        var currentCounter = 0
        var pointerLeft = 0
        var pointerRight = 0

        while(pointerRight < s.length){
            val currentChars = s.get(pointerRight)
            while(pointerLeft <= pointerRight && hashmap.contains(currentChars)){
                val leftChar = s.get(pointerLeft)
                hashmap.remove(leftChar)
                pointerLeft = pointerLeft + 1
            }
            hashmap[currentChars] = 1
            val windowSize = pointerRight - pointerLeft + 1
            // rumus counter adalah currentCOunter + panjang string yang diproses which is window size
            currentCounter = currentCounter + windowSize
            pointerRight = pointerRight + 1
        }

        return currentCounter
    }

}