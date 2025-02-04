# Intuition
[189. Rotate Array](https://leetcode.com/problems/rotate-array/description)

# Approach
결국, 뒤에 k만큼 원소가 맨 앞으로 오면 되는 문제이다.   
하지만, 공간 복잡도를 O(1)이라고 가정했을 때, 꽤나 복잡한 문제..    

in-place로 뒤에 k개의 원소를 그대로 맨 앞에서부터 나열하고, 앞에 있던 원소들을 그대로 뒤에 나열해야 한다.   

1. 뒤에서부터 k 번째를 기준으로 하여, (0 ~ k-1)원소들의 집합을 A, (k ~ n-1)원소들의 집합을 B라고 하자.
2. 결국 B -> A 순서대로 값을 나열해야 한다.
3. 이때, nums 배열의 순서를 다 뒤집는다.
4. 배열의 순서를 뒤집은 결과는 B -> A가 되기는 하지만, 각 집합의 원소들의 순서도 역순이 되었을 것이다.
5. 때문에, 이 상황에서 A 집합을 역순으로, B 집합도 역순으로 각각 돌려준다.   


# Complexity
**- Time complexity:**   
O(n): nums의 총 원소의 갯수가 n이라고 할 때, switching()의 시간복잡도는 O(2/n)이다.  

**- Space complexity:**    
O(1): in-place 방식으로 (two-pointers를 위한 인덱스 변수를 제외한) 별도의 메모리 공간을 할당 받지 않았으므로, O(1) 공간복잡도를 가진다.  

# Code
```kotlin []
class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        var _k = k % nums.size
        switching(nums, 0, nums.size-1)
        switching(nums, 0, _k-1)
        switching(nums, _k, nums.size-1)
    }

    fun switching(
        nums: IntArray,
        _li: Int,
        _ri: Int
    ) {
        var li = _li
        var ri = _ri

        while (li < ri) {
            val tmp = nums[li]
            nums[li++] = nums[ri]
            nums[ri--] = tmp
        }
    }
}
```
