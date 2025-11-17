class Solution {
    public int numSub(String s) {
        long ans = 0;
        long count = 0;
        long MOD = 1000000007;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                ans = (ans + (count * (count + 1) / 2) % MOD) % MOD;
                count = 0;
            }
        }

        ans = (ans + (count * (count + 1) / 2) % MOD) % MOD;

        return (int) ans;
    }
}
