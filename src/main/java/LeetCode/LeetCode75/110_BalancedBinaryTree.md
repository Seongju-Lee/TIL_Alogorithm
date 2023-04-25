[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
110. Balanced Binary Tree

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

    static int depth;
    static boolean ans;

    public int dfs(TreeNode root, int level) {

        if(root == null) {
            return level-1;
        }

        int lDepth = dfs(root.left, level+1);
        int rDepth = dfs(root.right, level+1);


        if(Math.abs(lDepth-rDepth) >= 2) {
            ans = false;
        }

        return Math.max(lDepth, rDepth);
        

    }
    
    public boolean isBalanced(TreeNode root) {
        

        if(root == null) return true;

        ans = true;
        dfs(root, 0);
        return ans;

    }
}
```