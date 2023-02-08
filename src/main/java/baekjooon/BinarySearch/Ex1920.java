package baekjooon.BinarySearch;

import java.util.*;
import java.io.*;

class Ex1920 {

    void solution(int n, int[] nArr, int m, int[] mArr) {

        Arrays.sort(nArr);
        for(int target : mArr) {

            int li = 0, ri = n-1;
            boolean isPresent = false;

            while (li <= ri) {

                int mid = (li + ri)/2;

                if(nArr[mid] > target) {
                    ri = mid-1;
                } else if(nArr[mid] < target){
                    li = mid + 1;
                } else {
                    isPresent = true;
                    break;
                }


            }

            if(isPresent)
                System.out.println(1);
            else
                System.out.println(0);

        }
    }

    public static void main(String[] args) throws IOException {

        Ex1920 main = new Ex1920();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");;
        int[] nArr = new int[n];
        for(int i=0; i<n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());

        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine() , " ");
        int[] mArr = new int[m];
        for(int i=0; i<m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        main.solution(n, nArr, m, mArr);

    }
}