class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
                if (i < s.length()
                    && (s.charAt(i-1) == '1'
                        || (s.charAt(i-1) == '2' && s.charAt(i) < '7'))) {
                    dp[i+1] += dp[i-1];
                }
            }
        }
        return dp[s.length()];
        // return recurse(s, 0);
    }

    public int recurse(String s, int ind) {
        if (ind == s.length()) {
            return 1;
        }
        if (s.charAt(ind) != '0') {
            // One Digit
            int res = recurse(s, ind + 1);
            // Two Digit
            if (ind < s.length() - 1
                && (s.charAt(ind) == '1' || (s.charAt(ind) == '2' && s.charAt(ind + 1) < '7'))) {
                res += recurse(s, ind + 2);
            }
            return res;
        }
        return 0;
    }
}
