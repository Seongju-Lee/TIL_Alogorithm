[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
211. Design Add and Search Words Data Structure


## Approach
- TrieNode 클래스는 Trie의 각 노드를 나타내며, 영문 소문자 알파벳에 해당하는 26개의 자식 노드 배열과 해당 노드가 단어의 끝인지 여부를 나타내는 매핑 정보이다.

- Trie를 사용하여 문자열을 추가하고, 검색 메서드에서는 '.' 문자를 포함한 와일드카드 검색
- addWord(): 문자열을 문자 단위로 Trie에 삽입합니다.
- search(): searchRecursive 메서드를 재귀적으로 호출하여 검색을 수행하며, 모든 가능한 경로를 탐색
[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

[//]: # (- Time complexity: O&#40;n&#41;   )

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // 시간 복잡도: O(m), 여기서 m은 단어의 길이
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    // 시간 복잡도: 최악의 경우 O(26^p), 여기서 p는 검색어의 길이, 상수 시간에 수행되는 것이 아님
    public boolean search(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && searchRecursive(child, word, index + 1)) {
                    return true;
                }
            }
        } else {
            int childIndex = c - 'a';
            TrieNode child = node.children[childIndex];
            if (child != null && searchRecursive(child, word, index + 1)) {
                return true;
            }
        }

        return false;
    }
}

```
