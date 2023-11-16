// 452. Minimum Number of Arrows to Burst Balloons
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[0], p2[0]));

        int minShots = 1;
        int rightMost = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int[] next = points[i];

            if (next[0] <= rightMost) {
                rightMost = Math.min(rightMost, next[1]);
            } else {
                rightMost = next[1];
                minShots++;
            }
        }

        return minShots;
    }
}
