// 62. Unique Paths
// https://leetcode.com/problems/unique-paths/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ways = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    ways[0][j] = 1;
                    continue;
                }

                if (j == 0) {
                    ways[i][j] = 1;
                    continue;
                }

                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }

        return ways[m - 1][n - 1];
    }
}
