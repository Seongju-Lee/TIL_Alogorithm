package section6;

import java.util.*;


public class Ex10 {

    int solution(int N, int C, int[] xArr){


        Arrays.sort(xArr); // 마구간 위치이기에 정렬.

        int min = xArr[0];
        int max = xArr[xArr.length-1] - xArr[0];
        int mid = (min + max)/2;

        while (min <= max) {

            mid = (min+max)/2;
            int cnt = 1;
            int pre = xArr[0];
            int now = xArr[0] + mid;

            for(int i=1; i<N; i++) {

                if(xArr[i] >= now && (pre <= now)) {
                    cnt++;
                    now = xArr[i] + mid;
                }

                pre = xArr[i];

                if(cnt >= C) {
                    min = mid + 1;
                    break;
                }
            }


            if (cnt < C){
                max = mid - 1;
            }

        }



        return min - 1;
    }

    public static void main(String[] args){

        Ex10 T = new Ex10();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] xArr = new int[N];


        for(int i=0; i<N; i++) {
            xArr[i] = sc.nextInt();
        }


        System.out.println(T.solution(N, C, xArr));




    }
}
