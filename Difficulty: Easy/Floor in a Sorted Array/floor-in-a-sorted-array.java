class Solution {
    static int findFloor(int[] arr, int x) {
        // code here
        // Binary Search Lower and Upper Bound Approach
        int length=arr.length;
        int left=0;
        int right=length-1;
        int lastOcc=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            //  arr[mid] is less than or equal to x 
            // Store current index 'mid' and search right half for a  larger valid floor
            if(arr[mid]<=x){
                lastOcc=mid;
                left=mid+1;
            }
            // arr[mid] is greater than x,so search left half
            else{
                right=mid-1;
            }
        }
    return lastOcc;
    }
}
