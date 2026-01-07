package com.interview.prep.interviewprep.leetcode.e0_template


/**
 * ==========================================
 * PROBLEM: 125. Palindrome
 * ==========================================
 *
 * URL: https://leetcode.com/problems/valid-palindrome/
 *
 * DESCRIPTION:
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * CONSTRAINTS:
 * - 1 <= s.length <= 2 * 10^5
 * - s consists only of printable ASCII characters.
 */

class Palindrome {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Two Pointers
     *
     * Strategy:
     * // nanti bisa pake bahasa indonesia di sini
     * // bisa share link draw io kalau mau pakai cara gambar dan simulasi
     *
     * We want to compare the string from the start and the end moving inwards.
     * Since we must ignore non-alphanumeric characters, we can't just reverse the string
     * blindly. We need dynamic skipping.
     *
     * Algorithm:
     * 1. Initialize two pointers: `left` at 0, `right` at s.length - 1.
     * 2. Loop while `left < right`:
     *    a. If `s[left]` is NOT a letter/digit, increment `left` and continue.
     *    b. If `s[right]` is NOT a letter/digit, decrement `right` and continue.
     *    c. Compare `s[left]` and `s[right]` (converted to lowercase).
     *       - If they are different -> Return False.
     *       - If they match -> Move both pointers (`left++`, `right--`).
     * 3. If the loop finishes without returning false, it is a palindrome. Return True.
     *
     * Complexity Analysis:
     * - Time Complexity: O(n) - We traverse the string at most once.
     * - Space Complexity: O(1) - We use constant extra space (pointers), no new string creation.
     */


    /**
    * ==========================================
    * SOLUTION
    * ==========================================
    **/

    fun execute(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            val charLeft = s[left]
            val charRight = s[right]

            // 1. Skip non-alphanumeric chars from the left
            if (!charLeft.isLetterOrDigit()) {
                left++
                continue
            }

            // 2. Skip non-alphanumeric chars from the right
            if (!charRight.isLetterOrDigit()) {
                right--
                continue
            }

            // 3. Compare characters (case-insensitive)
            if (charLeft.lowercaseChar() != charRight.lowercaseChar()) {
                return false
            }

            // 4. Move pointers inward after a successful match
            left++
            right--
        }

        return true
    }

}