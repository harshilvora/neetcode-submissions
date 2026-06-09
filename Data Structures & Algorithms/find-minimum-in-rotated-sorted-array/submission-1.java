class Solution {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int min = 10001;
        while(low<=high){
            //unsigned left shift only in Java
            int mid = (high + low) >>> 1;
            min = Math.min(nums[mid], min);
            if(nums[mid]>=nums[high]){
                low = mid +1;
            } else
                high = mid;
        }
        return min;
    }
}
