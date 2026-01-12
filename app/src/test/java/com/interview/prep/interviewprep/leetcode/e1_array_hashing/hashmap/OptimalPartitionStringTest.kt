package com.interview.prep.interviewprep.leetcode.e1_array_hashing.hashmap

import org.junit.Assert.assertEquals
import org.junit.Test

class OptimalPartitionStringTest {

    // 1. Instantiate the class to test
    private val solution = OptimalPartitionString()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: String,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testOptimalPartitionString() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase("abacaba", 4, "Gagal di karakter selang-seling"),
            TestCase("ssssss", 6, "Gagal di karakter yang semuanya sama"),
            TestCase("abcdef", 1, "Gagal di karakter yang semuanya unik"),
            TestCase("abccdde", 3, "Gagal di case standar (abc, cd, de)"),
            TestCase("ssssss", 6, "Gagal di karakter berulang berturut-turut")
        )

        // 4. Run the loop
        for (test in testCases) {
            val actual = solution.execute(test.input)
            println(" Test : ${test.input} | result : ${actual} | expected : ${test.expected}")
            assertEquals(
                "Failed on: ${test.message}",
                test.expected,
                actual
            )
        }
    }
}