[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
108. Convert Sorted Array to Binary Search Tree

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

    public void subTree(int[] arr, TreeNode tmp) {

        int li = 0;
        int ri = arr.length-1;
        int mid = (li+ri)/2;

        tmp.val = arr[mid]; // 현재 들어온 배열의 mid를 노드값으로 지정.

        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        if(leftArr.length != 0) {

            tmp.left = new TreeNode();
            subTree(leftArr, tmp.left); // mid기준 왼쪽배열을 재귀.

        }

        int[] rightArr = Arrays.copyOfRange(arr, mid+1, arr.length);
        if(rightArr.length != 0) {

            tmp.right = new TreeNode();
            subTree(rightArr, tmp.right); // mid 기준 오른쪽 배열 재귀

        }
        

    }

    public TreeNode sortedArrayToBST(int[] nums) {


        TreeNode tmp = new TreeNode();
        TreeNode ans = tmp;
        // mid 인덱스를 찾아서, nums 배열을 두 개로 분할.

        subTree(nums, tmp);
        

        return ans;

        
    }
}
```