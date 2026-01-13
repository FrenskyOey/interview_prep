package com.interview.prep.interviewprep.leetcode.e3_slidingwindow.dynamic


/**
 * ==========================================
 * PROBLEM: 3. Longest Substring Without Repeating Characters
 * ==========================================
 *
 * URL:https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * DESCRIPTION:
 *
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 *
 *
 */

class LongestDistinctString {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Sliding Window Dynamic
     *
     * Strategy:
     *
     * ini caranya tinggal pakai sliding window.. nanti setiap kali window bergeser ke kanan, maka dia akan menambahkan data chat ke hashmap
     * cara dia bergeser adalah dengan word/char terakhir dengan data hashmap, kalau misalkan hasil counternya masih diatas 0 artinya si pointer right yang akan jalan
     * sampai si pointer kiri = pointer kanan
     *
     * simulasi
     *
     * input
     * [a]bcabcbb
     * maxLength = 1
     * hashmap = {a: 1}
     * start = 0
     * end = 0
     *
     * [ab]cabcbb
     * maxLength = 2
     * hashmap = {a: 1, b: 1}
     * start = 0
     * end = 1
     *
     * [abc]abcbb
     * maxLength = 3
     * hashmap = {a: 1, b: 1, c:1}
     * start = 0
     * end = 2
     *
     * [abca]bcbb
     * maxLength = 3
     * hashmap = {a: 2, b: 1, c:1}
     * start = 0
     * end = 3
     * break soalnya a ada 2 bakal geser start sampai elemen a=1
     *
     * a[bca]bcbb
     * maxLength = 3
     * hashmap = {a: 1, b: 1, c:1}
     * start = 1
     * end = 3
     *
     * a[bcab]cbb
     * maxLength = 3
     * hashmap = {a: 1, b: 2, c:1}
     * start = 1
     * end = 4
     * break karena ada b = 2
     *
     * ab[cab]cbb
     * maxLength = 3
     * hashmap = {a: 1, b: 1, c:1}
     * start = 2
     * end = 4
     *
     * nanti bakal gini lah urutannya
     * ab[cabc]bb
     * abc[abc]bb
     * abc[abcb]b
     * abca[bcb]b
     * abcab[cb]b
     * abcab[cbb]
     * abcabc[bb]
     * abcabcb[b]
     *
     *
     * Algorithm
     *
     * Complexity Analysis:
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(s: String): Int {
        var counter = 0
        var endIndex = 0

        var contentString = ""

        if(s.isEmpty()){
            return 0
        }

        while(endIndex < s.length){
            val endChars = s.get(endIndex).toString()
            if(contentString.contains(endChars) == false){
                contentString = contentString+endChars
                val localCounter = contentString.length
                if(counter < localCounter){
                    counter = localCounter
                }
                endIndex = endIndex + 1
            }else{
                val stringBuilder = StringBuilder(contentString)
                stringBuilder.deleteCharAt(0)
                contentString = stringBuilder.toString()
            }
        }

        return counter
    }
}