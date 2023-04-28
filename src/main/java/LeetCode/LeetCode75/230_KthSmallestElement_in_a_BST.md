[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
230. Kth Smallest Element in a BST

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n)
기본적으로 이진트리에서 특정 값을 찾는다고 한다면, O(log(N))이 맞지만,  
해당 문제에서 최악의 경우 k가 마지막 값이라고 한다면 처음부터 끝까지 순회 하므로 O(n)의 시간복잡도를 가진다.

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    // 가장 왼쪽 하단으로 root를 이동 -> cnt=0
    // 재귀를 통한 복귀 -> cnt == k인 순간의 root.val 출력.
    int cnt=0;
    
    public void dfs(TreeNode root, int k, int[] ans) {

        if(root == null) return;

        if(root.left != null) {
            dfs(root.left, k, ans); 
        }

        cnt++;
        if(cnt == k) ans[0] = root.val;

        if(root.right != null) {
            dfs(root.right, k, ans);
        }
}

    public int kthSmallest(TreeNode root, int k) {
        
        int[] ans = new int[1];

        // 모든 요소를 탐색 -> DFS하면서, List에 요소 삽입.
        dfs(root, k, ans);
        return ans[0];
    }
}
```