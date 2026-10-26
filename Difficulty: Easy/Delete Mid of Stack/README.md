<h2><a href="https://www.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1">Delete Mid of Stack</a></h2>
<h3>Difficulty Level : Easy</h3>
<hr>

<div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);">

<p>
<span style="font-size: 18.6667px;">
Given a stack <strong>s</strong>, delete the middle element of the stack without using any additional data structure.
</span>
</p>

<p>
<span style="font-size: 18.6667px;">
The middle element is defined as the
<strong>floor((size of stack + 1) / 2)</strong>-th element from the bottom of the stack, using 1-based indexing.
</span>
</p>

<p>
<span style="font-size: 18.6667px;">
<strong>Note:</strong> The output shown by the compiler is the stack from top to bottom.
</span>
</p>

<p>
<span style="font-size: 14pt;"><strong>Examples:</strong></span>
</p>

<pre>
<strong>Input:</strong> s = [10, 20, 30, 40, 50]
<strong>Output:</strong> [50, 40, 20, 10]
<strong>Explanation:</strong> The bottom-most element is 10 and the
top-most element is 50. The middle element is 30,
which is deleted. The resulting stack is [10, 20, 40, 50].
</pre>

<pre>
<strong>Input:</strong> s = [10, 20, 30, 40]
<strong>Output:</strong> [40, 30, 10]
<strong>Explanation:</strong> The bottom-most element is 10 and the
top-most element is 40. The middle element is 20,
which is deleted. The resulting stack is [10, 30, 40].
</pre>

<p>
<span style="font-size: 14pt;"><strong>Constraints:</strong></span><br>
<span style="font-size: 14pt;">
2 ≤ s.size() ≤ 10<sup>4</sup><br>
-10<sup>6</sup> ≤ s[i] ≤ 10<sup>6</sup>
</span>
</p>

</div>

<br>

<p>
<span style="font-size: 18px;">
<strong>Topic Tags:</strong><br>
<code>Stack</code>&nbsp;
<code>Recursion</code>
</span>
</p>
