package com.interview.prep.interviewprep.leetcode.e3_slidingwindow.dynamic

import com.interview.prep.interviewprep.leetcode.e2_twopointers.TwoSum
import org.junit.Assert.assertEquals
import org.junit.Test

class CountSubstringCharTest {
    // 1. Instantiate the class to test
    private val solution = CountSubstringChar()

    // 2. Define the Test Case data structure
    data class TestCase(
        val input: String,
        val expected: Int,
        val message: String // Optional: helps identify which test failed
    )

    @Test
    fun testCountSubstringChar() {
        // 3. Define scenarios
        val testCases = listOf(
            TestCase("abc", 6, "Semua unik: a, b, c, ab, bc, abc"),

            // 2. Ada Karakter Berulang (Case Contoh)
            TestCase("abac", 8, "Berulang di awal: a, b, a, c, ab, ba, ac, bac"),

            // 3. Semua Karakter Sama
            TestCase("aaaa", 4, "Hanya substring panjang 1 yang valid: a, a, a, a"),

            // 4. Karakter Berulang Berdampingan
            TestCase("abccde", 12, "Ada double di tengah: a, b, c, c, d, e, ab, bc, cd, de, abc, cde"),

            // 5. String Kosong / Satu Karakter
            TestCase("z", 1, "Hanya satu karakter"),

            // 6. Karakter Berulang di Ujung
            TestCase("aa", 2, "Dua karakter sama"),

            // 7. Pola Zig-zag
            TestCase("ababa", 9, "Pola ab-ba berulang")
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