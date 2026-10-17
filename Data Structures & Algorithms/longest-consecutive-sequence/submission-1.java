class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        Arrays.sort(nums);

        int ans = 1, currans=1;
        for(int i=1; i<nums.length;i++){
            if(nums[i-1]==nums[i])
                continue;
            if(nums[i-1]+1 == nums[i]){
                currans++;
            }   else {
                currans=1;
            }
            ans = Math.max(ans, currans);
        }
        return ans;
    }
}

