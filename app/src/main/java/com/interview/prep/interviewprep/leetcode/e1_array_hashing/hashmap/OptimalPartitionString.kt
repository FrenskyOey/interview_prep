package com.interview.prep.interviewprep.leetcode.e1_array_hashing.hashmap

import kotlin.collections.contentToString
import kotlin.collections.toString

/**
 * ==========================================
 * PROBLEM: 2405. OptimalPartitionString
 * ==========================================
 *
 * URL:https://leetcode.com/problems/optimal-partition-of-string/description/
 *
 * DESCRIPTION:
 *
 * Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.
 *
 * Return the minimum number of substrings in such a partition.
 *
 * Note that each character should belong to exactly one substring in a partition.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abacaba"
 * Output: 4
 * Explanation:
 * Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
 * It can be shown that 4 is the minimum number of substrings needed.
 * Example 2:
 *
 * Input: s = "ssssss"
 * Output: 6
 * Explanation:
 * The only valid partition is ("s","s","s","s","s","s").
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only English lowercase letters.
 *
 */

class OptimalPartitionString {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: hashmap
     *
     * Strategy:
     * ini mah cupu, kamu tinggal taruh setiap characternya ke hashmap
     * nanti setiap character di check apakah mengandung datanya di hashmap atau nga
     * kalau iya maka nanti string nya di add langsung ke array atau langsung counter plus 1
     *
     * baca aja algrotimanya harusnya ngerti sih
     *
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
        var hashmap : HashMap<Char, Int> = hashMapOf()
        var content : StringBuilder = StringBuilder()
        var counters = 0

        for(char in s){
            if(hashmap.contains(char)){
                counters = counters + 1
                hashmap.clear()
                hashmap[char] = 1
            }else{
                hashmap[char] = 1
                content.append(char)
            }
        }

        counters = counters + 1

        return counters
    }
}

/*
for(char in s){
    if(hashmap.contains(char)){
        result.add(content.toString())
        content.clear()
        hashmap.clear()
        content.append(char)
        hashmap[char] = 1
    }else{
        hashmap[char] = 1
        content.append(char)
    }
}
result.add(content.toString())
print(result.toString())
return result.size*/


