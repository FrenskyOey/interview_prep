package com.interview.prep.interviewprep.leetcode.e4_stackqueque.stack.standard


/**
 * ==========================================
 * PROBLEM: 20. Valid Parentheses
 * ==========================================
 *
 * easy
 * URL: https://leetcode.com/problems/valid-parentheses/description/
 *
 * DESCRIPTION:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([])"
 * Output: true
 *
 * Example 5:
 * Input: s = "([)]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 *
 */


class ValidParentheses {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Stack
     *
     * Strategy:
     *
     * Example 4:
     * Input: s = "([])"
     * Output: true
     *
     * untuk ini kita harus pakai stack untuk menyimpan char satu demi satu.. jadi nanti kalau misalkan charnya = ({[ maka bakal kita masukkan ke stack
     * cuman kalau misalkan si chanya ]}) bakal kita pop dengan mengecek dulu kondisinya.. jadi kalau misalkan charnya ] maka kita peek nilai stack.. kalau nilainya
     * [ masih true selain itu langsung false
     *
     * contoh kasus kaya di atas
     * i1 -> i2
     * stack =(,[
     * i3 -> input ]
     * stack peek = [ artinya valid karena valid kita pop
     * stack = (
     * i4 -> input )
     * stack peek = ( artinya valid karena valid kita pop
     *
     * array habis.. nah kita cek panjang dari stack.. kalau isinya nga ksong return false, kalau misalkan kosong return true
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

    fun execute(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for(char in s){
            var peeks  = ' '
            if(!stack.isEmpty()){
                peeks = stack.first()
            }

            when(char){
                '(','[','{' ->{
                    stack.addFirst(char)
                }
                ')' ->{
                    if(!peeks.equals('(')){
                        return false
                    }
                    stack.removeFirstOrNull()
                }
                ']' ->{
                    if(!peeks.equals('[')){
                        return false
                    }
                    stack.removeFirstOrNull()
                }
                '}' ->{
                    if(!peeks.equals('{')){
                        return false
                    }
                    stack.removeFirstOrNull()
                }
                else ->{
                  // skip do nothing
                }
            }
        }

        return stack.isEmpty()
    }
}