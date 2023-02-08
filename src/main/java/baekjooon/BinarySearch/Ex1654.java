package baekjooon.BinarySearch;

import java.util.*;
import java.io.*;

class Ex1654 {

    static int n, k;
    static long[] arr; // 랜선 개수 목록


    void solution(long li, long ri){

        long answer=0;
        long middle=0;
        while (li <= ri) {

            middle = (li+ri)/2;
            long cnt = 0;

            for(int i=0; i<k; i++) {

                cnt += (arr[i]/middle);

            }


            System.out.println("cnt= " + cnt);
            System.out.println("middle= " + middle);
            System.out.println("li= " + li);
            System.out.println("ri= " + ri);

            System.out.println();
            if(cnt < n) ri = middle-1;
            else li = middle+1;

        }

        System.out.println(li-1);
        System.out.println(middle);
        System.out.print(middle-1);


        /**
         * 3 300
         * 150
         * 200
         * 100
         */
    }

    public static void main(String[] args) throws IOException {

        Ex1654 main = new Ex1654();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        k = Integer.parseInt(st.nextToken()); // 랜선의 개수
        n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        arr = new long[k];
        long minValue = 1;
        long maxValue = Integer.MIN_VALUE;
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
            maxValue = Math.max(maxValue, arr[i]);
        }

        main.solution(minValue, maxValue);



    }
}