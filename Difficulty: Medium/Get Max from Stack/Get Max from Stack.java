class SpecialStack {
    // Stack Design Pattern
     // Main stack → stores all values
    private Deque<Integer> stack = new ArrayDeque<>();
    // Max stack → stores the maximum value at each level
    private Deque<Integer> maxStack = new ArrayDeque<>();
    public SpecialStack() {
        // Define Stack
        // If you assign new ArrayDeque<>() when declaring the variables, the constructor body can be completely empty and it is valid
    }

    public void push(int x) {
        // Add an element to the top of Stack
        stack.push(x); // Push value into the main stack
        if(maxStack.isEmpty()){ // If maxStack is empty, current value becomes the maximum
            maxStack.push(x);
        }
        else{ // Push the maximum between current value and previous maximum
            maxStack.push(Math.max(x,maxStack.peek()));
        }
    }

    public void pop() {
        // Remove the top element from the Stack
        stack.pop();
        maxStack.pop(); // Remove corresponding maximum
    }

    public int peek() {
        // Returns top element of the Stack
        if(stack.isEmpty()){
            return -1;
        }
        else{
            return stack.peek();
        }
    }

    boolean isEmpty() {
        // Check if the stack is empty
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public int getMax() {
        // Finds maximum element of Stack
        if(maxStack.isEmpty()){
            return -1;
        }
        else{
             return maxStack.peek(); // Top of maxStack is the current maximum
        }
       
    }
}

/* Complexity:
Time Complexity:
 push(val): O(1)
 pop():     O(1)
 top():     O(1)
 getMin():  O(1)
 Space Complexity: O(N) — Stores at most 2 * N values across both stacks.
*/

