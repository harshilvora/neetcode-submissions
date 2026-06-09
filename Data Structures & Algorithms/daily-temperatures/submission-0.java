class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //Brute force
        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int temp = temperatures[i];
            for(int j=i+1; j<n; j++){
                if(temperatures[j]>temp){
                    ans[i] = j-i;
                    break;
                }
            }
        }
        return ans;
    }
}
