// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.merge(num , 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freq.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        int[] result = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            result[i++] = entry.getKey();
            if (i == k) break;
        }

        return result;
    }
}
