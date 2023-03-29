[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
116. Populating Next Right Pointers in Each Node
## Approach
<!-- Describe your approach to solving the problem. -->
BFS 이용.
<br> - 큐에다가 노드의 left, right를 순서대로 삽입함으로써 각 레벨의 노드가 순서대로 저장된다.
<br> - poll()한 노드의 next를 q의 최상단을 가리키도록 구현.
<br> - 각 레벨의 마지막 노드의 next는 null로 처리.

## Complexity
- Time complexity: O(V+E)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null) return root;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for(int i=0; i<size; i++) {

                Node node = q.poll();

                if(i == (size-1)) node.next = null;
                else node.next = q.peek();

                if(node.left != null) {
                    q.offer(node.left);
                    q.offer(node.right);
                }

            }

        }
        

        return root;
    }
}
```