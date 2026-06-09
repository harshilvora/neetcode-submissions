class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //Monotonic stack
        int n = temperatures.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> st = new ArrayDeque<Integer>();
        int i =0;
        st.push(i++);
        while(i<n){
            //Compare the latest value to the current value until you fulfill the condition
            while(st.peek()!=null && temperatures[st.peek()]<temperatures[i]){
                ans[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i++);
        }
        return ans;
    }
}
