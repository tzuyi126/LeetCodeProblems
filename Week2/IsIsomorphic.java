// 205. Isomorphic Strings
// https://leetcode.com/problems/isomorphic-strings
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();

        int[] sMap = new int[128];
        int[] tMap = new int[128];

        for (int i = 0; i < n; i++) {
            // if the last positions of the two characters are different, return false
            if (sMap[s.charAt(i)] != tMap[t.charAt(i)]) {
                return false;
            }

            // store the last position of the mapping characters
            sMap[s.charAt(i)] = i + 1;
            tMap[t.charAt(i)] = i + 1;
        }

        return true;
    }
}
