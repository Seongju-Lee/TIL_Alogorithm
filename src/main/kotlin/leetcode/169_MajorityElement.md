# Intuition
[169. Majority Element](https://leetcode.com/problems/majority-element/description)

# Approach
문제 조건에 공간 복잡도를 O(1)으로 구성하라고 정의되어 있다. 때문에, 가장 단순한 방법인 Map은 배제하고 고민   

처음에는 정렬한 후 인덱스를 이용해서 처리하려고 했으나, O(nlogn) 시간복잡도 때문에 배제  

**최종**    
문제에 "답으로 도출되는 값은 `nums`배열에서 절반을 초과해서 나타난다"라고 정의되어 있다.  
즉, 아래와 같은 식을 도출할 수 있다.   

`result - (nums.size - result) > 0`

위 식을 풀이 방식으로 설명하면 아래와 같다.   
count의 초기화 값은 0   
1. 정답인 값을 만날 때 count++,    
2. 정답이 아닌 값을 만날 때 count--    

**위 1,2 번을 반복해서 끝까지 가면, 결국 count는 양수인 것이다.**  


# Complexity
- **Time complexity:**    
O(n): nums의 크기를 n이라고 할 때, n만큼 for-loop 돌며 작업을 수행한다.   

- **Space complexity:**.   
O(1): 값이나 카운트 등을 저장할 변수를 제외하고, 추가적인 메모리 공간을 할당하지 않음   

# Code
```kotlin []
class Solution {
    fun majorityElement(nums: IntArray): Int {

        // 여태까지 가장 많이 나온 수: maxCountValue
        // 현재 수: num
        // 현재 수의 카운트: count
        
        // maxCountValue가 나올때마다 count++
        // 아니라면, count--

        // 다음 루프에서, 시작하자마자 조회 했는데 count가 0이라면,
        // 그 순간이 바로 maxCountValue가 변경되는 순간 + count를 1로 초기화
        var count = 0
        var maxCountValue = nums[0]
        for (num in nums) {
            if (count == 0) {
                maxCountValue = num
                count = 1
            }
            else if(num == maxCountValue) count++
            else count--
        }
        
        return maxCountValue
    }
}
```
