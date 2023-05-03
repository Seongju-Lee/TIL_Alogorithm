[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
173. Binary Search Tree Iterator

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
class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    // root의 작은값부터 빼내기 위해, left값들도 모두 push
    private void push(TreeNode root) {

        if(root == null) return;

        stack.push(root);
        push(root.left);
        
    }

    public BSTIterator(TreeNode root) {
        
        // 작은 값부터 stack에서 제외해야 한다.
        // root의 left만 우선 순차적으로 push
        push(root);
    }
    
    public int next() {

        TreeNode node = stack.pop();
        push(node.right); // 값을 빼내면서, 다음 값을 스택에 삽입.
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
```