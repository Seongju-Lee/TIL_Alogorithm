[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
76. Minimum Window Substring


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