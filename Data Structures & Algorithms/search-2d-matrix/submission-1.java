class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int[] low = {0,0};
        int[] high = {m-1, n-1};

        //Find the row where the target potentially exists
        while(low[0] <= high[0]){
            int mid = (low[0]+high[0])>>>1;
            //If target smaller then smallest element in row, then target would not be in an earlier row
            if(matrix[mid][0] > target){
                high[0] = mid - 1;
            }
            //If target bigger then the biggest element in row, then target would be in a later row 
            else if(matrix[mid][n-1] < target){
                low[0] = mid + 1;
            }
            //If target bigger than smallest element and smaller than biggest element in a row 
            else {
                break;
            }
        }

        //If row not at al found dont bother with column
        if(!(low[0] <= high[0]))
            return false;
        
        //Fixed row    
        int row = (low[0]+high[0])>>>1;

        //find the column next, normal binary search
        while(low[1] <= high[1]){
            int mid = (low[1]+high[1])>>>1;
            if(matrix[row][mid] == target)
                return true;
            else if(matrix[row][mid] > target)
                high[1] = mid -1;
            else
                low[1] = mid+1;
        }
        return false;

    }
}
