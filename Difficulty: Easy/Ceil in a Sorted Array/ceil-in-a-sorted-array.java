class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        //Binary Search Lower and Upper Bound Approach
        int length=arr.length;
        int left=0;
        int right=length-1;
        int firstOcc=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            //  arr[mid] is greater than or equal to x
            // Store current index 'mid' and search left half for a smaller index
            if(arr[mid]>=x){
                firstOcc=mid;
                right=mid-1;
            }
            // arr[mid] is smaller than x, so search right half
            else{
                left=mid+1;
            }
        }
    return firstOcc;
    }
}
