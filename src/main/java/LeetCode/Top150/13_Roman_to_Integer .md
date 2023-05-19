[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
13. Roman to Integer

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
class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans=0;

        for(int i=0; i<s.length(); i++) {


            if(s.charAt(i) == 'I') {

                if(i != s.length()-1 && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
                    ans+= (map.get(s.charAt(i+1))-1); // I가 1이기 때문.
                    i++;
                    continue;
                }

            }

            else if(s.charAt(i) == 'X') {
                
                if(i != s.length()-1 && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
                    ans+= (map.get(s.charAt(i+1))-10); // I가 1이기 때문.
                    i++;
                    continue;
                }
                
            }


            else if(s.charAt(i) == 'C') {

                if(i != s.length()-1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
                    ans+= (map.get(s.charAt(i+1))-100); // I가 1이기 때문.
                    i++;
                    continue;
                }

            }


            ans += map.get(s.charAt(i));
        }

        return ans;
    }
}
```