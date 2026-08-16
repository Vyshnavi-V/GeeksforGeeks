class Solution {
    public int findPages(int[] arr, int k) {
        // Binary Search On Answers Pattern
        //Edge Case:If the number of students exceeds the number of available books
        if(k>arr.length){
            return -1;
        }
        long max=0;
        long sum=0;
        for(int a:arr){
            max=Math.max(max,a);
            sum+=a;
        }
        // - low = max(arr): A single book cannot be split across students, Therefore, the maximum page limit per student must be at least the largest single book in the array.
        // - high = sum(arr): In the worst-case scenario (k = 1 student) that one student must read all the books.
        long low = max;
        long high = sum;
        long ans=-1;
        while(low<=high){
           long mid=low+(high-low)/2;
            if(myFun(arr,k,mid)){
                ans=mid; // Save the current possible min page
                high=mid-1; //Try to find a SMALLER  limit (search LEFT)
            }
            else{
                low=mid+1;
            }
        }
    return (int)ans;
        
    }
    // My Function- Determines whether all books can be allocated consecutively to at most 'k' students
    private boolean myFun(int[] arr,int k,long pages){
        int studCount=1; // Start by allocating books to the 1st student
        long sum=0; // Pages accumulated by the current student
        for(int pageCount:arr){
            if(sum+pageCount<=pages){  // If the current student can take this book without exceeding 'pages'
                sum+=pageCount;
            }
            else{ // Capacity exceeded: Allocate this book to a new student
                studCount++;
                sum=pageCount;
            }
        }
    return studCount<=k; // Return true if we managed to allocate all books using at most 'k' students
    }
}