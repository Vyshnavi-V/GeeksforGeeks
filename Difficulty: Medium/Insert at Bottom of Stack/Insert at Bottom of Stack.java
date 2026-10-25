class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        // code here
    // Recursive Stack Pattern
    // BASE CASE: If the stack is empty, push x into it.
    // Since the stack has no other elements, x becomes the bottommost element.
    if(st.isEmpty()){
        st.push(x);
        return st;
    }
    // Remove the top element and save it in 'top'. Each recursive call has its own local 'top' variable.
    int top = st.pop();
    // Recursively call insertAtBottom() to insert x at the bottom. The current call pauses here and waits for the recursive call to return.
    insertAtBottom(st,x);
    // The recursive call has returned. Restore the element saved in this call by pushing it back onto the stack.
    // Each waiting call restores its own saved 'top' value.
    st.push(top);
return st;        
    }
    
}
/*

Complexity:
- Time: \(O(n)\) — each existing element is popped and pushed back once.
- Auxiliary space: \(O(n)\) — due to recursive calls.

EXAMPLE:

Initial stack (bottom to top): [5, 3, 1]
Element to insert: x = 4

STEP 1: FIRST CALL
    Pop 1 and save top = 1.
    Stack becomes [5, 3].
    Call insertAtBottom(st, 4) again.
    The first call pauses and waits for the recursive call to return.

STEP 2: SECOND CALL
    Pop 3 and save top = 3.
    Stack becomes [5].
    Call insertAtBottom(st, 4) again.
    The second call pauses.

STEP 3: THIRD CALL
    Pop 5 and save top = 5.
    Stack becomes [].
    Call insertAtBottom(st, 4) again.
    The third call pauses.

STEP 4: BASE CASE
    The stack is empty.
    Push x = 4.
    Stack becomes [4].
    Return to the third call, which saved top = 5.

STEP 5: RESTORE 5
    The third call resumes at st.push(top).
    Its saved top = 5.
    Push 5 onto the stack.
    Stack becomes [4, 5] (bottom to top).
    Return to the second call, which saved top = 3.

STEP 6: RESTORE 3
    The second call resumes at st.push(top).
    Its saved top = 3.
    Push 3 onto the stack.
    Stack becomes [4, 5, 3] (bottom to top).
    Return to the first call, which saved top = 1.

STEP 7: RESTORE 1
    The first call resumes at st.push(top).
    Its saved top = 1.
    Push 1 onto the stack.
    Stack becomes [4, 5, 3, 1] (bottom to top).

FINAL STACK (bottom to top): [4, 5, 3, 1]

IMPORTANT POINTS:
1. Each recursive call removes and saves one element in 'top'.
2. When the stack becomes empty, x is pushed into it.
3. Each recursive call pauses until the next call returns.
4. After returning, each call restores its own saved element.
5. The original elements remain in their original order above x.
*/
