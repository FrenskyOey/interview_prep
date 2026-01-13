package com.interview.prep.interviewprep.leetcode.e3_slidingwindow.dynamic

/**
 * ==========================================
 * PROBLEM: 76. Minimum Window Substring
 * ==========================================
 * Hard
 * URL: https://leetcode.com/problems/minimum-window-substring/
 *
 * DESCRIPTION:
 *
 *Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 *
 */
class MinWindowSub {
    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Sliding WIndows + Hashmap
     *
     * Strategy:
     *
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     *
     * Rules : Pointer end akan jalan ke kanan selama tidak menemukan hashmap[key] yang nilainya 0
     * kalau nemu 0 berarti giliran start yang jalan sampai hashmap[key] = 1 dan pointer stop di char yang exist
     * pada data T
     *
     * hasmap :
     * initial
     * {A:1,B:1,C:1}
     * ADOBECODEBANC
     *
     * i1 [A]DOBECODEBANC
     * {A:0 B:1 C:1}
     *
     * i4 [ADOB]ECODEBANC
     * {A:0 B:0 C:1}
     *
     * i6 [ADOBEC]ODEBANC
     * {A:0 B:0 C:0}
     * currentString = ADOBEC
     *
     * i10 [ADOBECODEB]ANC
     * {A:0 B:0 C:0}
     *
     * start will move
     * s1 A[DOBECODEB]ANC
     * {A:1 B:0 C:0}
     *
     * s6 ADOBE[CODEB]ANC
     * {A:1 B:1 C:0}
     * stop karena iterasi sudah benar
     *
     * i13 ADOB[ECODEBANC]
     * {A:1 B:1 C:0}
     * start will move
     *
     * ADOBECODE[BANC]
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

    fun execute(s: String, t: String): String {
        var start = 0
        var end = 0
        var tHash : HashMap<Char,Boolean> = hashMapOf()
        var testHash : HashMap<Char,Int> = hashMapOf()
        var currentString = StringBuilder()
        var result = ""
        var beginRecord = false

        for(character in t){
            tHash[character] = true
            val counters = testHash[character] ?: 0
            testHash[character] = counters + 1
        }

        for(char in s){
            val isExist = tHash[char]
            //means character is not known
            if(isExist == null){
                if(beginRecord){
                    currentString.append(char)
                    println("ADD | ${currentString}")
                }
                end = end + 1
                continue
            }

            beginRecord = true
            currentString.append(char)
            println("ADD | ${currentString}")

            var counts = testHash[char] ?: 0

            //if 0 means the component already been used, need to move start point
            if(counts == 0){
                var shouldStop = false
                var isCharFounds = false

                while(start < end && shouldStop == false){
                    val startChar = s.get(start)
                    val isExist2 = tHash[startChar]

                    if(isCharFounds && isExist2 != null){
                        shouldStop = true
                        continue
                    }

                    currentString.deleteCharAt(0)
                    println("REMOVE | ${currentString}")
                    if(isExist2 == null){
                        start = start + 1
                        continue
                    }

                    val startCounter = testHash[startChar] ?: 0
                    testHash[startChar] = startCounter + 1

                    if(startChar.equals(char)){
                        isCharFounds = true
                    }
                    start = start + 1
                }
                counts = testHash[char] ?: 1
            }

            counts = counts - 1
            // remove hash if counter 0
            if(counts == 0){
                testHash.remove(char)
            }else{// just update char
                testHash[char] = counts
            }

            if(testHash.isEmpty()){
                if(currentString.length < result.length || result.isEmpty()){
                    result = currentString.toString()
                    println("RESULT | ${result}")
                }
            }

            end = end + 1
        }
        println("RESULT | ${result}")
        return result
    }

}