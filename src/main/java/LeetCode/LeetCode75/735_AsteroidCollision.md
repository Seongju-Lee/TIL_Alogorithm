[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
735. Asteroid Collision

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n)  
처음에는 O(n^2)이라고 판단함- 이유: 10개의 소행성이라고 가정할 때, 9까지 잘 추가하다가 10에서 0까지 --하는 경우  
하지만, **이 경우는 n^2이 아니라 n + n이다.** 또한, 계속 ++,-- 가 반복된다 하더라도 n이 순차적으로 n+1씩 증가하는 것일 뿐.  
n번 안에서 n번 수행되는 O(n^2)이라고 할 수 없다.

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<asteroids.length; i++) {

            // 기존의 소행성이 없거나, 기존&현재 소행성 모두 왼방향이거나, 현재 소행성이 오른방향이면, list에 추가한다.
            if( list.size() == 0 || (list.get(list.size()-1) < 0  &&  asteroids[i] < 0 ) || asteroids[i] > 0) {
                list.add(asteroids[i]);
            } else { 

                // 이전 소행성이 음수라면 continue
                if(list.get(list.size()-1) < 0) continue;

                // 현재 소행성(왼방향)이 기존 소행성(오른방향)들을 최대한 부순다.
                while (list.size() != 0 &&  list.get(list.size()-1) > 0 && (list.get(list.size()-1) + asteroids[i] < 0)){
                    list.remove(list.size()-1);
                }
                
                // 최대한 부순 이후, 끝난 결과가 아래와 같으면 처리
    
                // 다 부쉈거나 or 같은 방향(왼쪽방향)의 소행성인 경우, 새로운 소행성을 추가해준다.
                if(list.size() == 0 || list.get(list.size()-1) < 0) {
                    list.add(asteroids[i]);
                }
                // 상쇄 되는 경우, 기존의 소행성 하나만 제거
                else if(list.get(list.size()-1) + asteroids[i] == 0) {
                    list.remove(list.size()-1);
                }
                

            }
        }

        return list.stream().mapToInt(i -> i).toArray();
                
    }
}
```