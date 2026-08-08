class Solution {
    int countFreq(int[] arr, int target) {
        // Binary Search  ===Similiar to LC34===  (Ologn)
        //Function to find the first (leftmost) occurrence
        int start=leftRange(arr,target);
        //Function to find the last (rightmost) occurrence
        int end=rightRange(arr,target);
        // EDGE CASE: If target does not exist, leftRange returns -1,so return 0 as the final result
        if(start==-1){
            return 0;
        }
        //Return the no of occurances
        return end-start+1;
        
    }
    
    //LeftRange
    int leftRange(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        int start=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                start=mid;    //Record current match as a potential first position
                right=mid-1; // Keep searching left to see if target appears earlier
            }
            else if(arr[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
    return start;
    }
    
    //rightRange
    int rightRange(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        int end=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                end=mid;    // Record current match as a potential last position
                left=mid+1; // Keep searching right to see if target appears later
            }
            else if(arr[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
    return end;
        
    }
}








//1st Approach   ---o(n)
/*int length=arr.length;
        int count=0;
        for(int i=0;i<length;i++){
            if(arr[i]==target){
                count++;
            }
        }
    return count;*/
    
    
    
//2nd Approach ---O(n)
/*int length=arr.length;
        int left=0;
        int right=length-1;
        int count=0;
        while(left<=right){
           int mid=left+(right-left)/2;
           if(arr[mid]<target){
               left=mid+1;
           }
           else if(arr[mid]>target){
               right=mid-1;
           }
           else{  // mid==target
               while(arr[left]!=target){
                   left++;
               }
               while(arr[right]!=target){
                   right--;
               }
               return right-left+1;
           }
        }
    return 0;*/
