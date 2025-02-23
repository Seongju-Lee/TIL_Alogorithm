# Intuition
[6. Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/description)

# Approach
1. 처음에는 정답만을 도출하기 위해, **정답이 되는 값을 기준**으로 규칙을 찾음(**주어진 문자열의 인덱스를 마킹하는 방식**)  
   - BooleanArray(size)를 사용하여 어떤 문자를 사용했는지 마킹    
   - 각 행을 하나씩 탐색하면서 해당 행에 포함될 문자를 찾아 StringBuilder에 추가   
   - targetCount를 활용하여 다음에 추가할 문자를 결정  
   - 전체 문자열을 반복해서 확인하며 특정 조건이 만족되면 문자를 추가

2. 정답이 되는 값이 아닌, **지그재그로 값이 표현되는걸 기준으로 규칙**을 찾을 수 있음(**주어진 numRows에서 각 row마다 순서대로 위치할 문자를 추가하는 방식 -> 마지막에 각 row의 문자열을 순서대로 합침**)    
   - StringBuilder 배열을 사용하여 각 행을 저장
   - curRow와 goingDown 플래그를 사용하여 위/아래 방향을 결정
   - 한 번의 순회에서 모든 문자를 정확한 위치에 저장
   - 마지막에 각 행을 합쳐 최종 문자열을 생성

문제를 바라보는 관점에 따라 해결 가능한 시간복잡도가 O(n)이냐 O(n^2)이냐를 결정할 수 있었던 문제다.  시야를 좀 넓히자.  

# Complexity
- **Time complexity:**   
주어진 문자열의 길이가 n이고, 행의 길이가 r일 때,     
1번 방식의 경우 O(n*r)의 시간복잡도를 가지고, 2번의 경우 O(n+r)의 시간복잡도를 가진다.   


- **Space complexity:**    
주어진 문자열의 길이가 n이고, 행의 길이가 r일 때,     
1번 방식의 경우 O(n)의 공간복잡도를 가지고,
2번의 경우에도 O(n)의 공간복잡도를 가진다.(StringBuilder 타입을 다루는 배열의 크기는 r이지만, StringBuilder에 저장되는 각 문자의 갯수는 n 즉, StringBuilder에 저장되는 크기가 n이기 때문)   

# Code
**접근법 1**
```kotlin []
class Solution {
    fun convert(s: String, numRows: Int): String {
        val size = s.length // 문자열 전체 길이
        val mark = BooleanArray(size) // 문자열의 각 인덱스를 사용했는지 마킹

        // 현재 문자열이 zigzag로 채우고 있는 행 (다음 인덱스가 몇번째인지 계산하기 위함)
        var curRow = 1 

        // 현재 문자열에서 판단중인 인덱스
        var curIdx = 0
        // 다음으로 판단하고 싶은 문자가 몇번째인지 저장
        var targetCount = 0

        // 현재 체크하고 있는 문자가 몇번째인지 확인하는 용도
        var curCount = 0

        // row을 넘어가기 직전까지 문자열 반복해서 돈다.
        if (numRows == 1) return s

        var ans = StringBuilder()
        while (curRow <= numRows) {

            if (curIdx >= size) {
                curIdx = 0
                curRow++
            }

            if (!mark[curIdx]) {
                // target과 현재 카운트가 동일하면 문자열에 추가
                if (targetCount == curCount) {
                    mark[curIdx] = true
                    ans.append(s[curIdx])
                    targetCount = (numRows - curRow)*2
                    curCount = 1 // 다음으로 확인하고 있을 문자의 카운트값
                } else {
                    curCount++
                }
            } else { // 이미 마킹된 값 만나면, 처음 값으로 초기화
                targetCount = 0
                curCount = 0
            }
            
            curIdx++ // 인덱스는 계속 이동
        }
        return ans.toString()
    }
}
```



**접근법 2**
```kotlin []
class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s // 단일 행이면 그대로 반환

        val rows = Array(minOf(numRows, s.length)) {StringBuilder()}
        var curRow = 0
        var goingDown = false

        for (c in s) {
            rows[curRow].append(c)
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown
            curRow += if (goingDown) 1 else -1
        }

        val ans = StringBuilder()
        for (row in rows) {
            ans.append(row)
        }
        return ans.toString()
    }
}
```
