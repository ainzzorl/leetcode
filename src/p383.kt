// https://leetcode.com/problems/ransom-note/description/
class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val ransomMap = toFrequencyMap(ransomNote)
        val magazineMap = toFrequencyMap(magazine)
        for (c in ransomMap.keys) {
            val ransomValue = ransomMap.getValue(c)
            val magazineValue = magazineMap[c]
            if (magazineValue == null || magazineValue < ransomValue) {
                return false
            }
        }
        return true
    }

    private fun toFrequencyMap(s: String): Map<Char, Int> {
        val map = mutableMapOf<Char, Int>().withDefault { 0 }
        for (c in s) {
            map[c] = map.getValue(c) + 1
        }
        return map
    }
}
