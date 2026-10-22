class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        // Recursive Stack
        // BASE CASE:
        // If the stack is empty, stop the recursion and return.
        if(st.isEmpty()){
            return;
        }
        // Remove the top element and save it in 'top'. Each recursive call has its own 'top' variable.
        int top = st.pop();
        // Recursively reverse the remaining stack. The current call pauses here and waits for the recursive call to finish.
        reverseStack(st);
        // After the recursive call returns, insert the saved element at the BOTTOM of the stack.
        insertAtBottom(st,top);
    }
    private static void insertAtBottom(Stack<Integer> stack,int x){
        // BASE CASE:
        // If the stack is empty, push 'x'. Since there are no other elements, 'x' becomes the bottom.
        if(stack.isEmpty()){
            stack.push(x);
            return;
        }
        // Remove the current top element and save it in 'temp'. This element will be restored after 'x' is inserted.
        int temp = stack.pop();
        // Recursively insert 'x' into the remaining stack. The current call pauses and waits for this call to return.
        insertAtBottom(stack,x);
        // The recursive call has returned. Restore the saved element on top of the stack. Each waiting call restores its own saved 'temp'.
        stack.push(temp);
    }
}


/*
EXAMPLE: Reverse a stack using recursion

Initial stack (bottom to top): [1, 2, 3]
Top element: 3

STEP 1: reverseStack() - First call
    Pop 3 and save it in top = 3.
    Remaining stack: [1, 2]
    Call reverseStack() again.
    This call pauses and waits for the recursive call to return.

STEP 2: reverseStack() - Second call
    Pop 2 and save it in top = 2.
    Remaining stack: [1]
    Call reverseStack() again.
    This call also pauses and waits for the recursive call to return.

STEP 3: reverseStack() - Third call
    Pop 1 and save it in top = 1.
    Remaining stack: []
    Call reverseStack() again.
    This call pauses and waits for the recursive call to return.

STEP 4: BASE CASE
    The stack is empty.
    reverseStack() returns without popping anything.
    Control goes back to the third call, where top = 1.

STEP 5: INSERT 1 AT THE BOTTOM
    The third call executes insertAtBottom(stack, 1).

    The stack is empty, so push 1.
    Stack becomes [1] (bottom to top).

    insertAtBottom() returns.
    The third reverseStack() call finishes.
    Control goes back to the second call, where top = 2.

STEP 6: INSERT 2 AT THE BOTTOM
    The second call executes insertAtBottom(stack, 2).

    Initially, stack = [1].

    Pop 1 and save it in temp = 1.
    Stack becomes [].

    Recursively call insertAtBottom(stack, 2).
    The stack is empty, so push 2.
    Stack becomes [2].

    The recursive call returns.
    Execute stack.push(temp), where temp = 1.
    Push 1 on top of 2.
    Stack becomes [2, 1] (bottom to top).

    insertAtBottom() finishes.
    The second reverseStack() call finishes.
    Control goes back to the first call, where top = 3.

STEP 7: INSERT 3 AT THE BOTTOM
    The first call executes insertAtBottom(stack, 3).

    Initially, stack = [2, 1].

    First recursive call:
        Pop 1 and save it in temp = 1.
        Stack becomes [2].
        Recursively call insertAtBottom(stack, 3).

    Second recursive call:
        Pop 2 and save it in temp = 2.
        Stack becomes [].
        Recursively call insertAtBottom(stack, 3).

    Third recursive call:
        The stack is empty.
        Push 3.
        Stack becomes [3].
        Return to the second recursive call.

    RESTORE 2:
        The second recursive call resumes at stack.push(temp).
        Its saved temp = 2.
        Push 2 on top of 3.
        Stack becomes [3, 2] (bottom to top).
        This call finishes and returns to the first recursive call.

    RESTORE 1:
        The first recursive call resumes at stack.push(temp).
        Its saved temp = 1.
        Push 1 on top of 2.
        Stack becomes [3, 2, 1] (bottom to top).
        This call finishes.

    The first reverseStack() call also finishes.

FINAL STACK (bottom to top): [3, 2, 1]
Top element: 1

IMPORTANT POINTS:
1. reverseStack() pops and saves each element in its own top variable.
2. Each reverseStack() call pauses at reverseStack(st).
3. After the recursive calls return, the saved elements are
   inserted at the bottom one by one.
4. insertAtBottom() temporarily removes existing elements and
   saves each one in its own temp variable.
5. When a recursive call returns, execution continues at the
   next line: stack.push(temp).
6. Each call restores its own saved temp value.
7. The stack is reversed without using an additional stack.
*/
