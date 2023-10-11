// 76. Minimum Window Substring
// https://leetcode.com/problems/minimum-window-substring
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // store the counts of chars in t into frequency array
        int[] freq = new int[128];

        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }

        int minLength = Integer.MAX_VALUE;
        int left = 0, start = 0, count = 0;

        for (int right = 0; right < s.length(); right++) {
            Character rightChar = s.charAt(right);

            // if right pointer char is still required, count into current substring
            if (freq[rightChar] > 0) {
                count++;
            }
            freq[rightChar]--;

            // found a substring
            if (count == t.length()) {
                // if left pointer char exists more than 1 position in substring,
                // move the left pointer forward
                while (left < right && freq[s.charAt(left)] < 0) {
                    freq[s.charAt(left++)]++;
                }

                // save the result: start pointer, end pointer and min length
                if (minLength > right - left + 1) {
                    start = left;
                    minLength = right - left + 1;
                }

                // move left pointer forward
                freq[s.charAt(left++)]++;
                count--;
            }
        }

        return minLength != Integer.MAX_VALUE? s.substring(start, start + minLength) : "";
    }
}
