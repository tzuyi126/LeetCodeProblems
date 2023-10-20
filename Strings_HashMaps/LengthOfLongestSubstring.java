// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        // store current substring
        Queue<Character> q = new LinkedList();
        // store existed chars
        Set<Character> set = new HashSet<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            Character rightChar = s.charAt(right);

            // while the new char exists in set, move the left pointer forward
            while (set.contains(rightChar)) {
                Character removeChar = q.remove();
                set.remove(removeChar);
                left += 1;
            }

            // move the right pointer forward
            set.add(rightChar);
            q.add(rightChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
