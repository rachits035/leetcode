class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] st = new int[26];
        int[] ch = new int[26];
        for (int i = 0; i < s.length(); i++) {
            st[s.charAt(i) - 'a']++;
            ch[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (st[i] != ch[i])
                return false;
        }
        return true;

    }
}