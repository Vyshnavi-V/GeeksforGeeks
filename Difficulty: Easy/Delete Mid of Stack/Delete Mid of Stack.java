class Solution {
    public void deleteMid(Stack<Integer> s) {
        // code here
        // Stack Recursive Pattern
        // Calculate the middle position using 1-based indexing from the bottom.
        // Integer division automatically discards the decimal part.
        int removeIndex = (int)(s.size()+1)/2;
        // Calculate how many elements must be removed from the top before reaching the middle element.
        int removeCount=s.size()-removeIndex;
        int count =0; // Initialize count to 0 to track the elements popped from the top
        myFun(s,removeCount,count); // Call the recursive helper method.
        
    }
   private void myFun(Stack<Integer> stack,int removeCount,int count){
      // If count is less than removeCount, we haven't reached the middle element yet.
        if(count<removeCount){
            // Remove the top element and save it in 'top'. Each recursive call has its own 'top' variable.
            int top = stack.pop();
            count++; // Increase the count because one element was removed.
            // Recursively remove elements until the middle is reached.
            // The current call pauses and waits for the recursive call to return.
            myFun(stack,removeCount,count);
            stack.push(top);// The recursive call has returned. Restore this call's saved element to the top of the stack.
        }
       
        else{
            // The required number of elements has been removed from the top.
            // The current top is the middle element, so delete it.
            int remove = stack.pop();
            return; // Return to the previous recursive call.
        }
    }
}
/*
Time Complexity: O(n) – Each element is popped or restored once.
Space Complexity: O(n) – Recursive call stack..
*/

/*
EXAMPLE:

Initial stack (bottom to top): [10, 20, 30, 40, 50]

STEP 1: Calculate positions
    removeIndex = (5 + 1) / 2 = 3
    removeCount = 5 - 3 = 2
    count = 0

STEP 2: Remove elements above the middle
    Pop 50 -> save top = 50; count becomes 1.
    Pop 40 -> save top = 40; count becomes 2.

STEP 3: Delete the middle
    count == removeCount (2).
    Pop 30, which is the middle element.
    Stack remaining: [10, 20]

STEP 4: Restore elements as recursion returns
    First restore 40 -> stack becomes [10, 20, 40].
    Then restore 50 -> stack becomes [10, 20, 40, 50].

FINAL STACK (bottom to top): [10, 20, 40, 50]
OUTPUT (top to bottom): [50, 40, 20, 10]

*/




