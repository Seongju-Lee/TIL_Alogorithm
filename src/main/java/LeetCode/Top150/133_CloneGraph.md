[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
133. Clone Graph


## Approach
- DFS를 사용하여 그래프를 깊은 복사 
- visited 맵을 사용하여 이미 복사한 노드를 추적하고, 각 노드의 이웃을 재귀

<!-- Describe your approach to solving the problem. -->


## Complexity

- Time complexity: O(n)   

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 새로운 노드 생성
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
```
