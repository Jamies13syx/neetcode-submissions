class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < n) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                int pos = map.get(c);
                left = Math.max(pos + 1, left);
            } 
            map.put(c, right);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
