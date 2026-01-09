package com.interview.prep.interviewprep.leetcode.e1_array_hashing.hashmap
/**
 * ==========================================
 * PROBLEM: 49. Group Anagrams
 * ==========================================
 *
 * URL: https://leetcode.com/problems/group-anagrams/description/
 *
 * DESCRIPTION:
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 *
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */

class GroupAnagrams {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Hashmap
     *
     * Strategy:
     * // nanti bisa pake bahasa indonesia di sini
     *
     * untuk resolve logic ini berarti kita harus membuat class object kalau mau gampang
     *
     * kita bisa buat class namanya groups
     * didalamnya ada
     * val hashmapOrigins
     * val ArrayList<String> result
     *
     * nanti di dalam classnya ada fungsi buat ngecek apa kata input itu punya anagram yang sama dengan hashmap Origin
     * fun isDataAnagram(input : String) : Boolean
     * jika dia dataAnagram maka kita bisa masukin ke list
     * kalau bukan maka kita bisa buat data Group baru lewat fungsi constructor new instance dengan masukin stringnya
     *
     * jadi di data masternya testnya ada
     * ArrayList<Group> anagramGroupData
     *
     * dan nanti data anagramGroupData, tinggal dimasukkan saja nilai resultnya
     *
     * Algorithm
     *
     * Complexity Analysis: O(n)
     */

    class Group(){
        private var hash : HashMap<Char,Int> = hashMapOf()
        private val dataResult : ArrayList<String> = arrayListOf()

        companion object {
            fun createNewData(input: String): Group {
                val groupData = Group()
                groupData.hash = groupData.generateHashMap(input)
                groupData.dataResult.add(input)
                return groupData
            }
        }

        private fun generateHashMap(input : String): HashMap<Char,Int>{
            var result : HashMap<Char,Int> = hashMapOf()
            for(character in input){
                val counter = result.get(character) ?: 0
                result[character] = counter + 1
            }
            return result
        }

        fun checkAnagram(input: String) : Boolean {
            val inputHash = generateHashMap(input)

            if(inputHash.size != hash.size){
                return false
            }

            var result = true

            for(key in hash){
                val counterHash = key.value
                val counterInputHash = inputHash[key.key] ?: 0

                if(counterInputHash != counterHash){
                    return false
                }
            }

            dataResult.add(input)
            return result
        }

        fun getData():List<String>{
            return dataResult
        }

    }

    fun execute(strs: Array<String>): List<List<String>> {
        val groupData = arrayListOf<Group>()
        val result : ArrayList<List<String>> = arrayListOf()

        for(input in strs){
            var isAnagrams = false
            var indexCounter = 0
            while(isAnagrams == false && indexCounter <= (groupData.size-1)){
                val groups = groupData.get(indexCounter)
                isAnagrams = groups.checkAnagram(input)
                indexCounter = indexCounter + 1
            }

            if(isAnagrams == false){
                groupData.add(Group.createNewData(input))
            }
        }

        for(group in groupData){
            result.add(group.getData())
        }

        return result
    }

}