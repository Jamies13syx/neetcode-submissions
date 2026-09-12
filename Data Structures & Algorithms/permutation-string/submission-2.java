class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int len = s1.length();
        int[] count = new int[26];
        int[] count1 = new int[26];
    
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            count1[s2.charAt(i) - 'a']++;
            if (i >= len) {
                count1[s2.charAt(i - len) - 'a']--;
            }
            if (i >= len - 1 && helper(count, count1)) {
                return true;
            }
        }
        return false;
    }

    boolean helper(int[] count, int[] count1) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != count1[i]) {
                return false;
            }
        }
        return true;
    }
}
