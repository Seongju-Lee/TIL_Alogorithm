[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
101. Symmetric Tree

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n)  
좀 정확하게는 O(n/2)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    public boolean dfs(TreeNode left, TreeNode right) {
        
        if(left == null && right == null) return true;

        if(left == null || right == null) return false;

        if(left.val != right.val) return false;

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        
    
        return dfs(root.left, root.right);
    }
}
```