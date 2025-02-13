# Intuition
[274. H-Index](https://leetcode.com/problems/h-index/description)

# Approach

**풀이 1**
솔직히 바로 정렬 생각나긴 했음   
정렬된 배열에 대해 for-loop을 돌며, 현재 인덱스의 값과 남은 요소 갯수를 비교하면 된다.    


**풀이 2**
계수 정렬 알고리즘을 응용해서, 직접 정렬하지 않고 O(n) 시간복잡도로 풀이    

1. 인덱스가 인용 횟수이고, 값이 그에 해당하는 논문 갯수인 count[] 배열을 선언
2. count 배열의 크기는 n+1인데, 최대로 가능한 값이 n이기 때문이다. (h-index의 의미를 파악해보면, 결국 그 이상의 값은 의미가 없기 때문)
3. 즉, count 배열을 오른쪽에서 왼쪽 방향으로 갈수록, 현재의 논문은 최소한 누적합만큼 인용되었음을 의미한다.


h-index에서 결국 중요한 것은 인용 횟수와 논문 갯수가 동일한 최댓값이라는 것이다.  
즉 **인용횟수가 10인게 3개 있으면 h-index는 3이라는 의미**인데, 이 점이 가장 중요했다.   

현재는 인덱스는 그냥 논문 번호이고 값은 논문 인용횟수인 배열이다.  
결국, 논문 갯수와 인용 횟수가 배열에 표현되어야 한다. 이 방법이 정렬을 해서 **풀이 1** 방식대로 하거나 **풀이 2** 방식처럼 **새로운 배열에 인덱스와 값으로 이를 표현**하는 것이다.   



# Complexity
- **Time complexity**:     
O(n): 주어진 배열의 크기가 n일때, 최대 2*n 만큼의 시간이 소요됨    

- **Space complexity**:
O(n): n 크기를 가진 새로운 배열을 정의하고, 사용

# Code
```kotlin []
class Solution {
    fun hIndex(citations: IntArray): Int {
        val n = citations.size
        val count = IntArray(n+1) 

        // 배열 교차: 인덱스가 인용 횟수가 됨
        for (citation in citations) {
            // count 배열의 값은 인덱스만큼 인용된 논문 갯수
            if (citation >= n) { // n번 값: n번 이상 인용된 논문 갯수
                count[n] += 1
            } else {
                count[citation] += 1
            }
        }

        var total = 0
        for (i in n downTo 0) { // i는 인용 횟수
            total += count[i] // i번 이상 인용된 논문 갯수 누적 합
            if (i <= total) return i
        }
        return 0
    }
}
```
