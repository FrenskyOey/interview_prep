package com.interview.prep.interviewprep.leetcode.e4_stackqueque.queque.monotonic

/**
 * ==========================================
 * PROBLEM: 239. Sliding Window Maximum
 * ==========================================
 *
 * URL:https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * DESCRIPTION:
 *
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 *
 */

class SlidingWindowMaximum {

    /**
     * ==========================================
     * THEORETICAL APPROACH
     * ==========================================
     *
     * Topic: Monotonic Stack + Queque + Sliding Windows
     * maksimum bakal selalu menjadi milik que que first
     *
     * Strategy:
     *
     * [1],3,-1,-3,5,3,6,7
     * Que = [1]
     *
     *  [1,3],-1,-3,5,3,6,7
     *  Que = [3] -> 3 > 1 pop 1
     *
     *  [1,3,-1],-3,5,3,6,7
     *  Que = [3,-1]
     *
     *  1,[3,-1,-3],5,3,6,7
     *  Que = [3,-1,-3]
     *
     *  1,3,[-1,-3,5],3,6,7
     *  Que di pop karena ukuran que = 3, dikurangi agar bisa nampung 5
     *  Que = [-1] karena 5 > -3 maka pop
     *  Que = [] karena 5 > -1 maka pop
     *  insert 5
     *  Que = [5]
     *
     *  1,3,-1,[-3,5,3],6,7
     *  Que = [5,3]
     *
     *  1,3,-1,-3,[5,3,6],7
     *  karena 6>3 maka pop
     *  Que = [5]
     *  karena 6 > 5 maka pop
     *  Que = []
     *  insert 6
     *  Que = [6]
     *
     *  1,3,-1,-3,5,[3,6,7]
     *  karena 7>6 maka pop
     *  Que = []
     *  insert 7
     *  Que = [7]
     *
     *
     * Algorithm
     *
     * Complexity Analysis: O(n)
     */


    /**
     * ==========================================
     * SOLUTION
     * ==========================================
     **/

    fun execute(nums: IntArray, k: Int): IntArray{
        val result = arrayListOf<Int>()
        // data que que harus menyimpan index karena index dibutuhkan untuk proses penghapusan sliding windows
        val queQue = ArrayDeque<Int>()
        var indexes = 0
        var startPoint = k-1

        for(num in nums){
            if(queQue.isEmpty()){
                queQue.addLast(indexes)
            } else{
                val indexFirst = queQue.first()

                // remove elemen due to sliding windows
                if(indexFirst == indexes - k){
                    queQue.removeFirstOrNull()
                }

                var currentLast : Int? = null
                try{
                    currentLast = nums[queQue.last()]
                }catch(e:Exception){

                }

                while (currentLast != null && currentLast < num && !queQue.isEmpty()){
                    queQue.removeLastOrNull()
                    if(!queQue.isEmpty()){
                        currentLast = nums[queQue.last()]
                    }else{
                        currentLast = num
                    }
                }
                queQue.addLast(indexes)
            }
            if(indexes >= startPoint){
                result.add(nums[queQue.first()])
            }
            indexes = indexes + 1
        }

        return result.toIntArray()
    }
}