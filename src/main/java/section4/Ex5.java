package section4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Ex5 {

    /**
     * TreeSet 주요 메소드
     *
     * remove(value): set의 value값을 제거한다.
     * size(): 원소의 개수
     * first(): 가장 앞에 있는 원소(내림차순, 오름차순에 따라 가장 크거나 작은값 출력 가능.)
     * last(): 가장 마지막에 있는 원소
     *
     * @param n
     * @param k
     * @param inputArr
     */
    public void solution(int n, int k, Integer[] inputArr){

        Arrays.sort(inputArr, Collections.reverseOrder());

        /**
         * TreeSet: 범위 검색과 정렬에 유리한 클래스이다.
         * HashSet보다 데이터를 추가하거나 삭제하는데는 느리지만,
         * 정렬이나 범위검색이 필요할 때 사용해야 할 클래스.
         *
         * HashSet은 생성자로 Comparator<T>를 제공하지 않지만,
         * TreeSet은 Comparator<T>을 매개변수로 갖는 생성자가 있기 때문에 내림차순 Comparator을 적용할 수 있다.
         *
         *
         *
          */
//        HashSet<Integer> set = new HashSet<>(Collections.reverseOrder());
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder()); // treeSet

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){

                for(int s=j+1; s<n; s++){
                    set.add(inputArr[i] + inputArr[j] + inputArr[s]);

                }
            }
        }


//        Iterator it = set.iterator();

//        System.out.print(set.);

        List list = new ArrayList(set);
//        Collections.sort(list, Collections.reverseOrder());

        if(k >= list.size()) System.out.print(-1);
        else System.out.print(list.get(k-1));

    }
    public static void main(String[] args) throws IOException {

        Ex5 T = new Ex5();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] inputArr = new Integer[n];

        for(int i=0; i<inputArr.length; i++){
            inputArr[i] = sc.nextInt();
        }

        T.solution(n, k, inputArr);
    }
}
