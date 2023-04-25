[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
226. Invert Binary Tree

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
    public void bfs(TreeNode root) {

        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();
            for(int i=0; i<size; i++) {

                TreeNode tree = q.poll();

                TreeNode tmp = tree.left;
                tree.left = tree.right;
                tree.right = tmp;

                if(tree.left != null)
                    q.offer(tree.left);
                if(tree.right != null)
                    q.offer(tree.right);
                
                
            }
        }
    }

    public TreeNode invertTree(TreeNode root) {
        
       TreeNode answer = root;

       if(root == null) return answer;
       bfs(root);

       return answer;

    }
}
```