class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        //Sorting so that duplicates appear next to each other
        Arrays.sort(candidates);
        recurse(candidates, target, new ArrayList<>(), 0, ans);
        return ans;
    }

    public void recurse(
        int[] candidates, int target, List<Integer> curr, int ind, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
        }
        if (target < 0) {
            return;
        }
        for (int i = ind; i < candidates.length; i++) {
            //Starting index cant be same otherwise there will be duplicates
            if (i > ind && candidates[i] == candidates[i - 1])
                continue;
            curr.add(candidates[i]);
            recurse(candidates, target - candidates[i], curr, i + 1, ans);
            curr.remove(curr.size() - 1);
        }
    }
}
