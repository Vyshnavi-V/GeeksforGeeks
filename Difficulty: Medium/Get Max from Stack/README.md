# Get Max from Stack

**Difficulty:** Medium  


---

## Problem Statement

Implement a class **SpecialStack** that supports the following operations:

- **push(x)** – Insert an integer `x` onto the stack.
- **pop()** – Remove the top element from the stack.
- **peek()** – Return the top element from the stack. If the stack is empty, return `-1`.
- **getMax()** – Retrieve the maximum element from the stack in **O(1)** time. If the stack is empty, return `-1`.
- **isEmpty()** – Return `true` if the stack is empty, otherwise return `false`.

There will be a sequence of queries `queries[][]`. The queries are represented in numeric form:

- **`1 x`** → Call `push(x)`
- **`2`** → Call `pop()`
- **`3`** → Call `peek()`
- **`4`** → Call `getMax()`
- **`5`** → Call `isEmpty()`

The driver code will process the queries, call the corresponding functions, and print the outputs of `peek()`, `getMax()`, and `isEmpty()` operations.

**You only need to implement the above five functions.**

---

## Examples

### Example 1

```text
Input:
q = 7
queries[][] = [[1, 2], [1, 3], [3], [2], [4], [1, 1], [4]]

Output:
[3, 2, 2]
