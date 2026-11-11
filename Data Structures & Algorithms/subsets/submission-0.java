class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // Arrays.sort(nums);
        recurse(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public void recurse(int[] nums, int ind, List<List<Integer>> ans, List<Integer> curr) {
        ans.add(new ArrayList<>(curr));
        for(int i=ind; i<nums.length; i++){
            curr.add(nums[i]);
            recurse(nums, i+1, ans, curr);
            curr.remove(curr.size()-1);
        }
    }
}
