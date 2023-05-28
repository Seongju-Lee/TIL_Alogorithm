[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
76. Minimum Window Substring


[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n^2)
- Time complexity: O(n+m) -> n: li , m: ri

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public String minWindow(String s, String t) {
        
        int[] subIdx = new int[2]; // 최종 substring의 [startIdx, endIdx]

        Map<Character, Integer> expectMap = new HashMap<>();
        Map<Character, Integer> resultMap = new HashMap<>();

        for(Character c : t.toCharArray()) {
            expectMap.put(c, expectMap.getOrDefault(c, 0)+1);
        }

        int li=0, ri=0;
        int subLen=100_000;

        if(s.length() < t.length()) return "";

        //// START
        while (ri != s.length()) {


            while (ri<s.length() && !isStatisfied(expectMap, resultMap)) {
                if(expectMap.keySet().contains(s.charAt(ri))) { // t의 문자정보에 포함되는 문자라면,
                    resultMap.put(s.charAt(ri), resultMap.getOrDefault(s.charAt(ri), 0)+1 );
                }
                ri++;
            }

            // ri범위 때문에, 위 반복문이 끝난 경우 대비해서 만족하는 지 확인.
            if(isStatisfied(expectMap, resultMap) && subLen > (ri-li)) {

                subIdx[0] = li;
                subIdx[1] = ri;
                subLen = (ri-li);

            }

            if(resultMap.keySet().contains(s.charAt(li))) {

                if(resultMap.get(s.charAt(li)) == 1) {
                    resultMap.remove(s.charAt(li));
                } else {
                    resultMap.put(s.charAt(li), resultMap.get(s.charAt(li)) - 1);
                }
            }

            li++;

        }


        while (li<s.length() && isStatisfied(expectMap, resultMap)) {

            if(subLen > (ri-li)) {
                subIdx[0] = li;
                subIdx[1] = ri;
                subLen = (ri-li);
            }

            if(resultMap.keySet().contains(s.charAt(li))) {

                if(resultMap.get(s.charAt(li)) == 1) {
                    resultMap.remove(s.charAt(li));
                } else {
                    resultMap.put(s.charAt(li), resultMap.get(s.charAt(li)) - 1);
                }

            }

            li++;
        }

      
        return s.substring(subIdx[0], subIdx[1]);

    }

    private boolean isStatisfied(Map<Character, Integer> expectMap, Map<Character, Integer> resultMap) {


        // 1. keySet이 우선 일치
        if(expectMap.keySet().equals(resultMap.keySet())) {

            // 2. 각 key의 value가 expectMap보다 resultMap이 크거나 같아야 함.
            for(Character c : expectMap.keySet()) {

                
                if(expectMap.get(c) > resultMap.get(c)) {
                    return false;
                }
            }

            return true;

        }

        return false;
    }
}
```

```
class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()) {
            return "";
        }

        // t의 문자정보를 mapping
        int[] map = new int[128];
        Set<Character> set = new HashSet<>();
        for(char c : t.toCharArray()) {
            map[c] += 1;
            set.add(c);
        }


        int li=0, ri=0;
        int len = t.length(); // 찾아야 할 문자 개수
        int cnt = 0; 

        int minStart = Integer.MAX_VALUE;
        int minEnd = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;

        // s를 순차적으로 돌며, map을 참조하여 최소 길이 탐색
        while (ri != s.length()) {

            
            while (cnt != len) { // 찾아야 할 문자정보를 다 찾을 때까지, ri 이동하며 탐색

                if(ri >= s.length()) break; // ri 벗어나면 반복 종료
                
                if(map[s.charAt(ri)] > 0) { // t의 포함된 문자라면
                    cnt++; // 카운트 증가
                }

                map[s.charAt(ri)] -= 1;
                ri++;
            }

            while (cnt == len) { // cnt와 len이 같다면 짧은 문자열을 찾기위해, li를 이동.
                
                // 길이 update
                if((ri-li) < minLen) {
                    minLen = (ri-li);
                    minStart = li;
                    minEnd = ri;
                }


                // li 이동
                map[s.charAt(li)] += 1;
                if(map[s.charAt(li)] > 0) {
                    cnt -= 1;
                }


                li++;
                
            }

        }

        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart+minLen);
        
    }
}
```
