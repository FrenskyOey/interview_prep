package com.interview.prep.interviewprep.leetcode.e4_stackqueque.stack.monotonic

import kotlin.text.iterator

/**
 * ==========================================
 * PROBLEM: 316. Remove Duplicate Letters
 * ==========================================
 *
 * URL: https://leetcode.com/problems/remove-duplicate-letters/description/
 *
 * DESCRIPTION:
 *
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example 1:
 *
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 *
 *
 */

class RemoveDuplicateLetter {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Stack
     *
     * Strategy:
     *
     * Input: s = "cbacdcbc"
     * Output: "acdb"
     *
     * untuk resolve ini kita bisa menggunakan metode monotonic stack, dimana stack menyimpan nilai yang lebih besar dari dirinya
     * cuman ini nga sekedar monotonic biasa, melainkan monotonic dengan kondisi ekstra berikut adalah kondisinya
     *
     * 1.Nilai kondisi array berikutnya seharusnya lebih besar darinya
     * 2.Kalau lebih kecil dari kondisi sebelumnya maka kita bisa ngepop sampai terpenuhi, tapi...
     * 3.Kita hanya bisa ngepop nilai sebelumnya kalau si nilai itu bakal muncul di masa depan karena kalau kita main hapus, maka nanti kondisi distinct nga memenuhi
     * 4.Jadi kita harus mencatat juga frekuensi kemunculan tiap character, dan mengurangi frekuensinya, setiap kali datanya sudah di proses
     * 5.kalau si nilai frekuensinya 0 artinya nga ada kasus pop, dan kita lanjut
     * 6.nah berikutnya adalah kasus kalau pas masukin nilai char, rupanya nilai charnya sudah pernah dimasukkan, di sini kita harus ngebypass valuenya, karena
     * nilainya memang sudah pernah masuk
     *
     *
     * contoh : cbacdcbc
     * initial :
     *  frekuensi {a: 1, b : 2, c: 4, d: 1}
     *  seen {}
     *  stack{}
     *
     *  i1 : insert c
     *  frekuensi {a: 1, b : 2, c: 3, d: 1}
     *  seen {c}
     *  stack{c}
     *
     *  i2 : insert b
     *  frekuensi {a: 1, b : 1, c: 3, d: 1}
     *  seen {b}
     *  stack{b} -> kita pop c karena c > b dan fekuensi c masih > 0 dan kita hapus seen c juga dan mengurangi frekuensi b
     *
     *  i3 : insert a
     *  frekuensi {a: 0, b : 1, c: 3, d: 1}
     *  seen {a}
     *  stack{a} -> kita pop b karena b > a dan fekuensi b masih > 0 dan kita hapus seen b juga dan mengurangi frekuensi a
     *
     *  i4 : insert c
     *  frekuensi {a: 0, b : 1, c: 2, d: 1}
     *  seen {a,c}
     *  stack{a,c} -> masukin c di seen dan stack dan hanya mengurangi frekuensi c
     *
     *  i5 : insert d
     *  frekuensi {a: 0, b : 1, c: 2, d: 0}
     *  seen {a,c,d}
     *  stack{a,c,d} -> masukin d di seen dan stack dan hanya mengurangi frekuensi d
     *
     *  i6 : insert c
     *  frekuensi {a: 0, b : 1, c: 1, d: 0}
     *  seen {a,c,d}
     *  stack{a,c,d} -> C sudah pernah seen sebelumnya jadi kita skip
     *
     *  i7 : insert b
     *  frekuensi {a: 0, b : 0, c: 0, d: 0}
     *  seen {a,c,d ,b}
     *  stack{a,c,d,b} -> harusnya d di pop, cuman karena counter d = 0 maka langsung masukin b
     *
     *  i8 : insert c
     *  frekuensi {a: 0, b : 0, c: 0, d: 0}
     *  seen {a,c,d ,b}
     *  stack{a,c,d,b} -> C sudah pernah seen sebelumnya jadi kita skip
     *
     * Algorithm
     *
     * Complexity Analysis: o(N)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(s: String): String {
        val tracker : HashMap<Char,Int> = hashMapOf()
        val frequency : HashMap<Char,Int> = hashMapOf()
        val stacks = ArrayDeque<Char>()
        var result = ""

        // record Frequency
        for(chars in s){
            var counter = frequency[chars] ?: 0
            counter = counter + 1
            frequency[chars] = counter
        }
        var lastChar : Char? = null

        for(char in s){
            var counter = frequency[char] ?: 0

            when{
                lastChar == null ->{
                    stacks.addFirst(char)
                    tracker[char] = 1
                    lastChar = char
                }
                tracker.contains(char) ->{
                    //skip handling contains
                }else ->{
                    var isAfter = char >= lastChar
                    if(isAfter == false){
                        var shouldStop = false
                        while(shouldStop == false && !stacks.isEmpty()){
                            val peeks  = stacks.first()
                            val freq = frequency[peeks] ?: 0
                            when{
                                freq <= 0 -> {
                                    shouldStop = true
                                    continue
                                }
                                char < peeks ->{
                                    stacks.removeFirstOrNull()
                                    tracker.remove(peeks)
                                }else -> {
                                    shouldStop = true
                                }
                            }
                        }
                    }
                    stacks.addFirst(char)
                    tracker[char] = 1
                    lastChar = char
                }
            }
            counter = counter - 1
            frequency[char] = counter
        }


        result = stacks.joinToString("").reversed()
        return result
    }

}