[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
39. Combination Sum

## Approach
<!-- Describe your approach to solving the problem. -->
중복을 허용하기 때문에, 한 위치에서 계속 실행될 수 있도록 현재 위치에서 재귀를 호출한다.  
재귀를 통해 target값을 만족할 때까지 동일 값을 더하고, target값을 넘어가는 순간에 인덱스를 다음으로 넘기는 식으로 진행.  


## Complexity
- Time complexity: O(n^target)  
주어진 배열의 원소가 1이라는 가정 하에 중복을 허용하는 상태에서 target의 합 만큼 재귀를 수행하기 때문이다.

<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {

    public void rec(List<List<Integer>> ans, List<Integer> list, int[] arr, int target, int start, int sum) {

        for(int i=start; i<arr.length; i++) {

            if(sum > target) {
                break; // 뒤의 것들을 굳이 더해볼 필요가 없으므로 반복문 제어
            }
            else if(sum == target){
                ans.add(new ArrayList<>(list));
                break; // 뒤의 것들을 더하면 안되므로. 반복문 제어.
            }
            else {

                list.add(arr[i]);
                rec(ans, list, arr, target, i, sum+arr[i]);
                list.remove(list.size()-1);
                // sum -= arr[i]; // 다음 인덱스를 새롭게 더하기 위해. 기존의 것 빼줌.
                
            }

        }


    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        rec(ans, new ArrayList<>(), arr, target, 0, 0);
        
        return ans;
    }   
}
```