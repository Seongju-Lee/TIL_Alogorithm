[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
117. Populating Next Right Pointers in Each Node II
## Approach
<!-- Describe your approach to solving the problem. -->
한 level에 따른 pointer 변경을 요함.  
BFS를 이용해서 풀이.

## Complexity
- Time complexity: O(n^2)
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
        
        // level 별로 연결정보가 발생함. -> BFS로 접근하여 level별로 처리 가능.
        // next 포인터의 deafult setting이 Null이므로 별다르게 안건드림.

        Node tmp = new Node();
        node.
        if(root == null) return root;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {


            int size = q.size();

            while (size != 0) {
                size--;

                Node node = q.poll();

                // 자식 노드가 null이 아니면 q에 추가(다음 level)
                if(node.left != null) 
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);

                
                if(size != 0)
                    node.next = q.peek();
                else
                    node.next = null;
            }

            
        }
        return root;



    }
}
```