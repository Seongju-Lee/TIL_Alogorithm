[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
49. Group Anagrams


[//]: # (## Approach)

[//]: # ()
[//]: # (<!-- Describe your approach to solving the problem. -->)

## Complexity

- Time complexity: O(n^3)   

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    private boolean isAnagram(String str1, String str2) {


        if(str1.length() != str2.length()) return false;


        int[] arr1 = new int[26];

        // str1에 대한 문작구성을 매핑
        for (char c : str1.toCharArray()) {
            arr1[c - 'a']++;
        }

        // str2 문자구성을 보면서 매핑정보(arr1)에서 문자 개수를 차감
        for (char c : str2.toCharArray()) {
            arr1[c - 'a']--;
        }


        // 문자 구성이 같다면 매핑 정보의 남은 문자 개수가 모두 0이어야 함.
        for (int i=0; i<26; i++) {
            if(arr1[i] != 0 ) return false;
        }

        return true;



    }

    public List<List<String>> groupAnagrams(String[] strs) {
        
        // List 내부에 List가 존재 -> ans
        List<List<String>> ans = new ArrayList<>();



        for(String str : strs) {

            boolean isAdded = false;

            // 한 문자열을 만날 때, ans 돌면서
                // 동일하지 않다면, 다음 list로 이동
            for (List<String> list : ans) {

                // list.get(0)과 문자구성이 동일하면 추가 후, 다음 문자열로 이동;
                if (isAnagram(str, list.get(0))) {

                    list.add(str);
                    isAdded = true;
                }

            }

            // ans 끝까지 돌았다면(= 현재 문자열을 추가하지 못했다면)
            if(!isAdded) {

                // ans 새로운 list형태로 하여 추가
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                ans.add(tmp);
            }


        }


        return ans;

        
        
        
    }
}
```