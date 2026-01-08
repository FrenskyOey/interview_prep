package com.interview.prep.interviewprep.leetcode.e1_array_hashing.simple_array

/**
 *  (X) Estimation time arround 50 minute
 * ==========================================
 * PROBLEM: 151. Reverse Words in a String
 * ==========================================
 *
 * URL:https://leetcode.com/problems/reverse-words-in-a-string/submissions/
 *
 * DESCRIPTION:
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 *
 *
 */

class ReverseString {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: String + 2 pointer
     *
     * Strategy:
     * sebetulnya kalau mau pakai cara paling gampang tinggal pakai bulit innya kotlin pakai
     * string.split[" "]
     * abis itu tinggal di reverse dah itu di filter yang datanya nga empty dah itu tinggal di join pakai spasi
     * cuman demi implementasi algotitma, cara itu kita exclude dulu
     *
     * ini lebih baik kita mulai dari belakang string.. jadi nanti di kita bakal pkae pointer dan juga length,
     * jadi kita bakal ambil substringnya dari pointer ke pointer + length nantinya
     * dan length akan kembali ke 0 kalau menemukan spasi
     * kalau misalkan lengthnya 0 tapi malah dapat spasi, kita bisa by pass.. karena artinya nga ada data yang harus disimpan
     *
     * ini masih cara brute force sebenarnya
     *
     * Example 1:
     *
     * Input: s = "the sky is"
     * Output: "is sky the"
     *
     * pointer 1 = 9
     * length = 0
     *
     * pointer 1 terus maju sampai dapat spasi di 7
     * pointer 1 = 7
     * length = 2
     *
     * result = s.substring(8..(7+2)9)
     *
     * ambil sub char 8-9 = is masukin ke string depan
     * output : is
     *
     * update length = 0
     * pointer 1 maju lagi sampai nemu spasi di index 3
     *
     * pointer 1 = 3
     * length = 3
     *
     * result = s.substring(3..(3+3)6)
     *
     * output : is the
     * update length = 0
     *
     * pointer 1 maju lagi sampai nemu spasi di index 0
     *
     * pointer 1 = 0
     * length = 3
     *
     * result = s.substring(0..(0+3)3)
     * output : is the sky
     *
     * Algorithm
     *
     * Complexity Analysis: time complexity O(n), memory complecity O(n)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(s: String): String {
        var result = ""
        var pointer1 = s.length
        pointer1 = pointer1 - 1
        var length = 0
        //result = s.substring(10..14).trim()

         while(pointer1 >= 0){
            val chars = s[pointer1]
            if(chars.equals(' ')){
                if(length == 0){
                    pointer1 = pointer1 - 1
                    continue
                }

                val newString = s.substring((pointer1+1)..(pointer1+length))
                if(result.isEmpty()){
                    result += newString
                }else{
                    result += " " + newString
                }
                pointer1 = pointer1 - 1
                length = 0
                continue
            }
            length = length + 1
            pointer1 = pointer1 - 1
        }

        // add last words
        if(length > 0){
            val newString = s.substring(0..(length - 1)).trim()
            if(result.isEmpty()){
                result += newString
            }else{
                result += " " + newString
            }
        }

        return result
    }
}