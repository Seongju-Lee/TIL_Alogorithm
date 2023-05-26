[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
30. Substring with Concatenation of All Words


[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n^2)   

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> ans = new ArrayList<>();

        int wordLen = words[0].length();
        int subLen = wordLen*words.length;

        Map<String, Integer> expectMap = new HashMap<>();
        for( String word : words ) {
            expectMap.put(word, expectMap.getOrDefault(word, 0)+1);
        }

        for (int i=0; i<=(s.length()-subLen); i++) {

            String substr = s.substring(i, i+(subLen)); // 순열의 substring 출력
            
            Map<String, Integer> resultMap = new HashMap<>();
            // substr의 한 단어씩 탐색하여 expectMap과 resultMap 비교
            for(int j=i; j<(i+subLen); j+=(wordLen)) {
                
                String word = s.substring(j, j+(wordLen));
                resultMap.put(word, resultMap.getOrDefault(word, 0)+1);
            }

            if(resultMap.equals(expectMap)) {
                ans.add(i);  // 답으로 substring 시작 인덱스 추가
            }

        }

        return ans;
    }
}
```