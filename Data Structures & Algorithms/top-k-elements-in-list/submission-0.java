class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> element = heap.poll();
            res[i] = element.getKey();
        }
        return res;
    }
}
