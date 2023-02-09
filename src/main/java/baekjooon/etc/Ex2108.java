import java.util.*;

class Ex2108{

    static long maxValue=0, max=Long.MIN_VALUE, min=Long.MAX_VALUE;
    static double sum=0;
    void solution(int n, List<Integer> list, Map<Integer, Integer> map) {

        Collections.sort(list);

        // 평균
        System.out.println(Math.round(sum/n));

        // 중앙값
        System.out.println(list.get((list.size()-1)/2));

        // 최빈값
        long cnt=0;
        List<Integer> keyList = new ArrayList<>(map.keySet());

        keyList.sort((i1, i2) -> {
            if(map.get(i1) == map.get(i2)){
                return i1-i2;
            }
            return map.get(i2).compareTo(map.get(i1));
        });


        if(keyList.size() > 1 && map.get(keyList.get(1)) == map.get(keyList.get(0)))
            System.out.println(keyList.get(1));
        else
            System.out.println(keyList.get(0));

        // 범위
        System.out.print(max-min);
    }

    public static void main(String[] args) {

        Ex2108 main = new Ex2108();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {

            int inputValue = sc.nextInt();

            list.add(inputValue);
            sum += inputValue;

            map.put(inputValue, map.getOrDefault(inputValue, 0)+1);
//
//            if(maxValue < map.get(inputValue))
//                maxValue = map.get(inputValue);

            if(max < inputValue) max = inputValue;
            if(min > inputValue) min = inputValue;

        }


        main.solution(n, list, map);

    }
}