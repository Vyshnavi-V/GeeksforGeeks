class Solution {
    public int aggressiveCows(int[] arr, int k) {
        
        // Binary Search On Answers Pattern
        
        Arrays.sort(arr);
        int length=arr.length;
        int low=1;
        int high=arr[length-1] - arr[0];// Maximum possible distance (distance between the two farthest stalls
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(myFun(arr,k,mid)){
                ans=mid; // Save the current possible distance
                low=mid+1; //Try to find a LARGER distance (search RIGHT)
            }
            else{
                high=mid-1;
            }
           
            
        }
    return ans;
    }
    // Helper Function, checks if at least 'k' cows can be placed with a minimum gap of 'dist'.
    private boolean myFun(int[] arr,int k,int dist){
        
        int d=1; // placed the 1st cow at the very first stall arr[0]
        int last=arr[0];// Track of the most recently placed cow
        for(int i=1;i<arr.length;i++){
            if(Math.abs(arr[i]-last)>=dist){
                d++;
                last=arr[i];// Update the position of the last placed cow
            }
        }
    return (d>=k);// Return true if we placed 'k' or more cows successfully
    }
       
}

/*      NOTE:
         * WHY WE MUST SORT THE ARRAY:
         * -------------------------------------------------------------------------
         * 1. Stalls exist on a number line. Our approach
         *    places cows sequentially from left to right.
         * 
         * 2. What happens without sorting? (Example):
         *    Suppose unsorted arr = [1, 10, 2, 7, 5], k = 3, target distance = 5.
         *    - Cow 1 placed at index 0 -> stall 1 (last = 1, count = 1)
         *    - Cow 2 placed at index 1 -> stall 10 (|10 - 1| = 9 >= 5 -> count = 2)
         *    - Cow 3 placed at index 2 -> stall 2  (|2 - 10| = 8 >= 5 -> count = 3)
         *    => The code says "valid" (count >= 3).
         *    => BUT IN REALITY: Cow 1 is at 1 and Cow 3 is at 2! The distance between 
         *       them is |2 - 1| = 1, which violates our minimum required distance of 5!
         * 
         * 3. What sorting guarantees:
         *    Sorted arr = [1, 2, 5, 7, 10].
         *    Because positions are strictly increasing:
         *    arr[i] >= last >= all earlier cows.
         *    If (arr[i] - last >= dist), then arr[i] is GUARANTEED to be even further
         *    away from all previously placed cows. We only need to check against 'last'!
         * =========================================================================
         */