[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
617. Merge Two Binary Trees
## Approach
<!-- Describe your approach to solving the problem. -->
dfs를 이용한 풀이.
<br>전위순회를 적용하였다. 한쪽 노드의 값이 null이면 다른 쪽으로 이동하고, 두 방향에 모두 null이면 최하단이므로 null을 리턴하였다.


## Complexity
- Time complexity: O(n) 
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    TreeNode dfs(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null)
            return null;
        else if(root1 == null && root2 != null) {
            return root2;
        } else if(root1 != null && root2 == null) {
            return root1;
        }

        TreeNode answer = new TreeNode(root1.val+root2.val);
        answer.left = dfs(root1.left, root2.left);
        answer.right = dfs(root1.right, root2.right);

        return answer;

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        TreeNode answer = dfs(root1, root2);

        return answer;
    }
}
```