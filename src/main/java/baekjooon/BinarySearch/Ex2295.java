package baekjooon.BinarySearch;

import java.util.*;

public class Ex2295 {

    static int n;

    static int[] arr;
    static List<Integer> two;

    void solution() {

        int answer = 0;
        int r = 0;

        Collections.sort(two);

        for(int k=(arr.length-1); k>=0; k--) { // k: 뒤에서부터 탐색

            for(int z=k; z>=0; z--) {  // 정렬된 arr에서 탐색하므로 가장 뒤에서부터 진행해서, 최초에 만족하면 최댓값이다.
                int value = arr[k] - arr[z]; // value값을 two에서 이진탐색

                if(Collections.binarySearch(two, value) > -1){
                    System.out.print(arr[k]);
                    return;

                    /*if(value > answer) {
                        r = arr[k];
                        answer = value;
                    }*/
                }

            }

        }

        // System.out.println(r);
    }

    public static void main(String[] args) {

        Ex2295 main = new Ex2295();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n]; // 값 입력 배열
        two = new ArrayList<>(); // x+y list

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for(int i=0; i<n; i++) { // x+y 배열
            for(int j=i; j<n; j++) {
                two.add(arr[i] + arr[j]);
            }
        }

        main.solution();

    }
}
