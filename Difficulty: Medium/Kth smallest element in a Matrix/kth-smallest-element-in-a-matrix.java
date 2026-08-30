class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // code here
        // Binary Search On Answers Pattern
        int m=mat.length; // row length
        int n=mat[0].length; // col length
        int low=mat[0][0]; //Smallest possible value is at the top-left: mat[0][0]
        int high=mat[m-1][n-1]; //Largest possible value is at the bottom-right: mat[m-1][n-1]
        int ans =low;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(myFun(mat,k,mid)){  // Check if there are at least k elements <= mid in the matrix
                ans=mid;  // mid is a valid candidate; record it and search for a smaller one to the left
                high=mid-1;
            }
            else{
                low=mid+1;  // Fewer than k elements are <= mid; the answer must be larger so move to right
            }
        }
    return ans; // Contains the exact kth smallest element
    }
    //Helper method to count how many elements in the matrix are <= target.
    private boolean myFun(int[][] mat,int k,int target){
        int m=mat.length; // row length
        int n=mat[0].length; // col length
        // Start from the bottom-left corner: (row = m - 1, col = 0)
        int row=m-1;
        int col=0;
        int count=0;
        while(row>=0 && col<n){
                if(mat[row][col]>target){
                // If the current cell is greater than target,then all elements to its right in this row are also > target (sorted row).
                // So Move up to a smaller value.
                row--;
            }
            else {   
                // If the current cell is <= target, all elements above it in this column are also <= target (sorted column).
                // Add all elements from index 0 to row (total: row + 1 elements).
                count+=row+1;
                col++;  // Move right to check the next column
            }
        }
    return count>=k; // Return whether we found at least k elements <= target
    }
}


/*
 ============================================================================
  DRY RUN NOTES: Staircase Search Trace (kthSmallest in Sorted Matrix)
 ============================================================================

 Matrix (4 x 4):
 ---------------
   Index:     0    1    2    3
   Row 0:  [ 16,  28,  60,  64 ]
   Row 1:  [ 22,  41,  63,  91 ]
   Row 2:  [ 27,  50,  87,  93 ]
   Row 3:  [ 36,  78,  87,  94 ]

 Target Rank: k = 3
 Initial Range: low = mat[0][0] = 16, high = mat[3][3] = 94
 Expected Output: 27

 Core Pointer Movement Logic in myFun(mat, k, target):
 -----------------------------------------------------
  - Start at bottom-left corner: (row = 3, col = 0)
  - If mat[row][col] > target:
        row--                 (Value is too large; move up)
  - If mat[row][col] <= target:
        count += (row + 1)    (All cells from row 0 to current row are <= target)
        col++                 (Move right to the next column)
*/










