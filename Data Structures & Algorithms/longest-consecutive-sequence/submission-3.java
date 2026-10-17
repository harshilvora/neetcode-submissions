class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // Create set by removing duplicates of all numbers
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for (int num : set) {
            //Find beginning index
            if (!set.contains(num - 1)) {
                // Check consecutive numbers from current number if it exists in set
                int length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
}