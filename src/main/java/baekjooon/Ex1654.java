package baekjooon;

import java.util.Scanner;


public class Ex1654 {

    static long min, max;

    long solution(int K, int N, long[] lanCables){


        /*
        K<= N

        min 초기값은 1임.
        max는 lanCables 중 최소값.

        middle = (min + max) / 2

        이진 탐색하며 좁히기.
         */

        long answer = 0;
        long middle;

        max++;
        while(min <= max) {

            middle = (min + max) / 2;
//            System.out.println(middle);

            long tmp = 0;

            for (int i=0; i < lanCables.length; i++) {
                tmp += (lanCables[i] / middle);
            }

            System.out.println("가져갈 lan 길이: " + tmp);
            if(tmp < N){
                max = middle - 1;
            }

            else {
                min = middle + 1;

//                if(tmp == N && (answer < middle))
//                    answer = middle;
            }

        }


        return min-1;
    }

    public static void main(String[] args){

        Ex1654 T = new Ex1654();
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt(); // 가지고 있는 랜선의 개수
        int N = sc.nextInt(); // 필요한 랜선의 개수

        long[] lanCables = new long[K];
        min = 1;
        max = Long.MIN_VALUE;

        for(int i=0; i<K; i++){
            lanCables[i] = sc.nextLong();
            if(lanCables[i] > max) max = lanCables[i];
        }

        System.out.print(T.solution(K, N, lanCables));

    }
}
