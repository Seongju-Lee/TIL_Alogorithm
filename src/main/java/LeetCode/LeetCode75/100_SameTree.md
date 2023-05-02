[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
100. Same Tree

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(N)  
모든 노드 한번씩만 순회 - DFS

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```

class Solution {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // 전위, 중위, 후위 뭐든 똑같이 시작해서 똑같이 끝나면 true;

        if(p == null && q == null) return true;

        if(p == null || q == null) return false;

        if(p.val != q.val) return false;
        

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}
```