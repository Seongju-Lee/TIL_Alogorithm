[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
150. Evaluate Reverse Polish Notation

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();

        int res = 0;
        for(String token : tokens) {

            int tmp = 0;
            switch (token) {

                case "+":
                    tmp = stack.pop() + stack.pop();
                    stack.push(tmp);
                    break;
                
                case "-":
                    tmp = -1*(stack.pop() - stack.pop());
                    stack.push(tmp);
                    break;

                case "*":
                    tmp = (stack.pop() * stack.pop());
                    stack.push(tmp);
                    break;

                case "/":
                    int a = stack.pop();
                    int b = stack.pop();
                    tmp = b/a;
                    stack.push(tmp);
                    break;
                
                default:
                    stack.push(Integer.parseInt(token));
                    break;

            }
        }

        return stack.pop();
    }
}
```