[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
438. Find All Anagrams in a String
## Approach
<!-- Describe your approach to solving the problem. -->
값을 비교할 배열을 만드는 것과, 슬라이드 윈도우 방식으로 모든 경우의 수를 순차탐색 하는 것이 포인트이다.

## Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        

        int li=0, ri=-1; // li: s의 현재 탐색 인덱스, ri: s에서 p를 찾기위해 탐색중인 현재 인덱스
        int len = p.length();

        int[] arr = new int[26];
        for(char c : p.toCharArray()) { // 문자열 p에 각 문자의 개수를 저장할 변수.
            arr[c-97] += 1;
        }
        int[] tmp = new int[26];
        List<Integer> answer = new ArrayList<>(); // 정답 list
        int curLen = 0;

        while (li <= (s.length()-p.length())) { // p의 문자열 길이를 벗어나기 전까지 li 움직임.
             
            while (curLen != len) {// 현재 탐색중인 문자열의 길이(curLen)가 p의 길이(len)만큼 탐색하지 못했을 때.
                
                curLen++;
                ri++;

                if(ri >= s.length()) { // 탐색 가능한 범위가 끝났을 때, 더이상 탐색할 필요가 없음.
                    return answer;
                }

                if(arr[s.charAt(ri)-97] == 0) { // 현재 탐색 중인 문자가 p에 없는 문자일 때.
                    li = ri+1; // li를 없는 문자 다음으로 이동
                    curLen = 0; // 탐색중인 문자열의 길이를 0으로 초기화.
                    tmp = new int[26];
                } else {
                    tmp[s.charAt(ri)-97] += 1; // 탐색중인 문자의 개수 추가.
                }

            }

            if(Arrays.equals(arr, tmp)) {
                answer.add(li); // 정답 리스트에 인덱스 추가.
            }

            tmp[s.charAt(li)-97] -= 1;
            li++;
            curLen--;
        }

        return answer;
        
    }
}
```