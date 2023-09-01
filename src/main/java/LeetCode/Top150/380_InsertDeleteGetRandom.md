[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
380. Insert Delete GetRandom

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(log(n))

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class RandomizedSet {

    List<Integer> list;
    int idx=0;

    public RandomizedSet() {
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        int idx = Collections.binarySearch(list, val);

        // System.out.println(val +", " + list + ", " + (-idx) +", " + idx);
        if(idx < 0) {
            list.add(-idx-1, val);
            return true;
        } else {
            return false;
        }
      
    }
    
    public boolean remove(int val) {
        
        int idx = Collections.binarySearch(list, val);
        if(idx < 0) {
            return false;
        }

        else {
            list.remove((Integer) val);
            return true;
        }

    }
    
    public int getRandom() {
        
        int idx=(int)(Math.random()*(list.size()));
        return list.get(idx);
    }
}

```