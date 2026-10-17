class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Chars = new int[26];

        if (s1.length() > s2.length()) {
            return false;
        }
        // Calculate the count of characters in s1
        for (int i = 0; i < s1.length(); i++) {
            s1Chars[s1.charAt(i) - 'a']++;
        }
        // fixed window to compare both strings
        int window = s1.length();
        int l = 0, r = 0;
        // Count s2 characters
        int[] s2Chars = new int[26];
        while (r < s2.length()) {
            int ch = s2.charAt(r) - 'a';
            // If character doesnt exist in s1, then we can skip till this character + 1
            if (s1Chars[ch] == 0) {
                l = r + 1;
                s2Chars = new int[26];
            }
            // If character exists then add in s2 array count
            else {
                s2Chars[ch]++;
            }
            // On fixed window width 
            if (r - l + 1 == window) {
                //compare the s1 and s2 array counts
                if(Arrays.equals(s1Chars, s2Chars)) {
                    return true;
                }
                // If not same counts remove leftmost
                else if (l < s2.length()) {
                    s2Chars[s2.charAt(l) - 'a']--;
                    l++;
                }
            }
            r++;
        }
        return false;
    }
}
