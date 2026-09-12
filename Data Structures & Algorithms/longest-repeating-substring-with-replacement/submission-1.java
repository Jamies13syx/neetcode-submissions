class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        // max frequency
        int max = 1;
        int res = 1;
        for (int right = 0; right < n; right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            max = Math.max(max, map.get(s.charAt(right)));
            while (right - left + 1 - max > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
