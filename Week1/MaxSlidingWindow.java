// 239. Sliding Window Maximum
// https://leetcode.com/problems/sliding-window-maximum/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // dq stores the index of nums value with values from largest to smallest
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            // Append new num's index into dq
            while (true) {
                if (dq.isEmpty()) {
                    dq.addLast(i);
                    break;
                }
                int value = nums[dq.peekLast()];

                if (value < nums[i]) {
                    dq.removeLast();
                } else {
                    dq.addLast(i);
                    break;
                }
            }

            // Append maximum value into result array
            if (i + 1 - k >= 0) {
                while (i - dq.peekFirst() >= k) {
                    dq.removeFirst();
                }
                
                int max = nums[dq.peekFirst()];
                result[j++] = max;
            }
        }

        return result;
    }
}
