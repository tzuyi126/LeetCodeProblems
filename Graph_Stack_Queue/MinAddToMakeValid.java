// 921. Minimum Add to Make Parentheses Valid
// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid
class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0;
        int leftParenthesisCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftParenthesisCount++;
                continue;
            }

            if (leftParenthesisCount == 0) {
                res++;
            } else {
                leftParenthesisCount--;
            }
        }
        
        return res + leftParenthesisCount;
    }
}
