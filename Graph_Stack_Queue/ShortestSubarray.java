// 862. Shortest Subarray with Sum at Least K
// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int n = nums.length;

        // Create long array to store cummulative sum of all nums
        // prefixSum[i] = nums[0] + nums[1] + ... + nums[i - 1]
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        Deque<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n + 1; i++) {

            // Sum[q.first : i] >= k
            while (!q.isEmpty() && prefixSum[i] - prefixSum[q.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - q.pollFirst());
            }

            // Sum[q.last : i] <= 0
            while (!q.isEmpty() && prefixSum[i] - prefixSum[q.peekLast()] <= 0) {
                q.pollLast();
            }

            q.add(i);
        }

        return minLength == Integer.MAX_VALUE? -1 : minLength;
    }
}
