class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, piles[i]);
        }
        // upper bound of k is the max number
        int low = 1;
        int high = max; 
        int ans = 0;
        //Using binary search as we have to find the minimum number in a sorted set fulfilling a condition
        //Using <= because low and high can reach the highest number as an answer i.e. max
        while(low<=high){
            int mid = (high + low) >>> 1;
            int hour = 0;
            for(int i=0; i<n; i++){
               hour += (int) Math.ceil((double)piles[i]/mid);
            }
            //Condition achieved but still find smallest value
            if(hour <= h){
                ans = mid;
                high = mid -1;
            }
            //If hours taken is more than h then increase the lower bound to current value (mid) +1
            //low = mid+1 and not low = mid because mid is already checked and its not the answer 
            else if(hour > h){
                low = mid+1;
            }
        }
        return ans;
    }
}
