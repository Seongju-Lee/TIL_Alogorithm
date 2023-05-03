[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
199. Binary Tree Right Side View

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

    public void bfs(TreeNode root, List<Integer> list) {

        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for(int s=0; s<size; s++) {

                TreeNode node = q.poll();

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

                if(s == size-1) {
                    list.add(node.val);
                }

            }
        }


    }
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();

        if(root == null) return list;

        bfs(root, list);
        return list;

    }
}
```