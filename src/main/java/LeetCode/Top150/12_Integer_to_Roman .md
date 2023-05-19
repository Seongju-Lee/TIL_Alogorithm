[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
12. Integer to Roman


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
    public String intToRoman(int num) {
        
        List<Integer> list = new ArrayList<>();

        // 각 자리 단위마다의 자릿수를 구하기 위함.
        for (int i=1000; i>=1; i/=10) {
            if(num/i != 0) {
                list.add((num/i)*i);
                num %= i;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i : list) {

            if( i >= 1000) { // 천의 자리
                int size = i/1000; // 1000 매핑 문자 개수
                sb.append("M".repeat(size)); // 매핑 개수만큼 문자열에 추가
            }

            else if( i >= 100) { // 백의 자리
                int size = i/100; // 100 매핑 문자 개수

                if (size == 4) {
                    sb.append("C").append("D");
                }

                else if( size == 9) {
                    sb.append("C").append("M");
                }
                else if (size >= 5) {
                    sb.append("D");
                    sb.append("C".repeat(size-5)); // D넣고, 나머지는 C 삽입
                } else {
                    sb.append("C".repeat(size)); // 500이하면, 그냥 C를 개수만큼 삽입
                }

            } 


            else if( i >= 10) { // 십의 자리

                int size = i/10;

                if (size == 4) {
                    sb.append("X").append("L");
                }

                else if( size == 9) {
                    sb.append("X").append("C");
                }
                else if (size >= 5) {
                    sb.append("L");
                    sb.append("X".repeat(size-5));
                } else {
                    sb.append("X".repeat(size));
                }
            }


            else if( i >= 1) { // 십의 자리

                int size = i;

                if (size == 4) {
                    sb.append("I").append("V");
                }

                else if( size == 9) {
                    sb.append("I").append("X");
                }
                else if (size >= 5) {
                    sb.append("V");
                    sb.append("I".repeat(size-5));
                } else {
                    sb.append("I".repeat(size));
                }
            }

        }

                
        return sb.toString();
    }
}
```