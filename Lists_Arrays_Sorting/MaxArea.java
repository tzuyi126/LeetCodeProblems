// 11. Container With Most Water
// https://leetcode.com/problems/container-with-most-water/
class Solution {
    public int maxArea(int[] height) {
        int maxWidth = height.length;
        int left = 0, right = maxWidth - 1;
        int maxArea = 0;

        while (left < right) {
            int area = Math.min(height[right], height[left]) * (right - left);

            maxArea = Math.max(maxArea, area);

            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
