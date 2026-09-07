class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] keyArr = new int[26];
            for (char c : str.toCharArray()) {
                keyArr[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (keyArr[i] != 0) {
                    key.append((char)('a' + i)).append(keyArr[i]);
                }
            }
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
