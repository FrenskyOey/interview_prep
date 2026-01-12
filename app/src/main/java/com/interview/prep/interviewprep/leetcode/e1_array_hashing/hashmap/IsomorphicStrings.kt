package com.interview.prep.interviewprep.leetcode.e1_array_hashing.hashmap

/**
 * ==========================================
 * PROBLEM: 205. Isomorphic Strings
 * ==========================================
 *
 * difficulty easy
 *
 * URL: https://leetcode.com/problems/isomorphic-strings/description/
 *
 * DESCRIPTION:
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 *
 * Output: true
 *
 * Explanation:
 *
 * The strings s and t can be made identical by:
 *
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 *
 * Output: false
 *
 * Explanation:
 *
 * The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
 *
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 *
 * Output: true
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 *
 *
 */

class IsomorphicStrings {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: hashmaps
     *
     * Input: s = "egg", t = "add"
     * output true
     *
     * karena huruf egg bisa digantikan jadi add dimana e ganti jadi a dan g ganti jadi d
     *
     * Strategy:
     * kita harus menyimpan 2 hashmap satu buat string s dan satu buat string t
     * nanti di setiap iterasi bakal kita cek tuh counter nya apa counter hashmap s dan counter t sama atau nga..
     * kalau masih sama, lanjut, beda langsung kick
     *
     * contoh iterasi
     * i1 : h[e] = 0  s[a] = 0 {masih sama kita lanjut dengan simpan nilainya}
     * h[e] = 1  s[a] = 1 {kita simpan frekuensinya}
     *
     * i2 = h[g] = 0 dan s[d] = 0 {masih sama kita lanjut dengan simpan nilainya}
     * h[e] = 1     s[a] = 1
     * h[g] = 1     s[g] = 1
     *
     * i3 = h[g] = 1 dan s[g] = 1 {masih sama kita lanjut dengan simpan nilainya}
     * h[e] = 1     s[a] = 1
     * h[g] = 2     s[g] = 2
     *
     * for berakhir langsung return true
     *
     * contoh input 2
     * Input: s = "foo", t = "bar"
     *
     * i1 : h[f] = 0  s[b] = 0 {masih sama kita lanjut dengan simpan nilainya}
     * h[f] = 1  s[b] = 1 {kita simpan frekuensinya}
     *
     * i2 = h[o] = 0 dan s[a] = 0 {masih sama kita lanjut dengan simpan nilainya}
     * h[f] = 1     s[b] = 1
     * h[o] = 1     s[a] = 1
     *
     * i3 = h[o] = 1 dan s[r] = 0 ga sama langsung return false
     *
     * Algorithm
     *
     * Complexity Analysis: O(N)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(s: String, t: String): Boolean {
        var index = 0
        var hashmapS : HashMap<Char,Int> =hashMapOf()
        var hashmapT : HashMap<Char,Int> =hashMapOf()
        var hashmapChars : HashMap<Char,Char> =hashMapOf()

        if (s.length != t.length) return false

        while(index < s.length){
            val charS = s.get(index)
            val charT = t.get(index)
            val counterS = hashmapS[charS] ?: 0
            val counterT = hashmapT[charT] ?: 0

            println("iteration $index | $charS : $counterS | $charT : $counterT")
            if(counterT == counterS){
                var relatedChar = hashmapChars[charS] ?: ""

                if(relatedChar == ""){
                    hashmapChars[charS] = charT
                }else if(relatedChar != charT){
                    return false
                }

                hashmapS[charS] = counterS + 1
                hashmapT[charT] = counterT + 1
            }else{
                return false
            }
            index = index + 1
        }
        return true
    }

}