[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
71. Simplify Path


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
    public String simplifyPath(String path) {
        

        String[] arr = path.split("/");
        Stack<String> stack = new Stack();

        for (String s : arr) {

            if(s.equals("") || s.equals(".")) continue;

            if(s.equals("..")){
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }

            else {
                stack.push(s);
            }

        }

        StringBuilder sb = new StringBuilder();

        if(stack.isEmpty()) return "/";

        for(String s : stack) {
            sb.append("/").append(s);
        }


        return sb.toString();
    }
}
```