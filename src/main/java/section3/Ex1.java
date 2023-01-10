package section3;

import java.net.Inet4Address;
import java.util.*;

public class Ex1 {

    public void solution(int n, int m, int[] nArr, int[] mArr){

        // 시간복잡도 O(N)으로 맞춰서 한번에 정렬하기 위한 알고리즘
        int nPointer = 0, mPointer = 0;

        ArrayList<Integer> answer = new ArrayList<>();

        while (nPointer < n && mPointer < m){

            if(nArr[nPointer] <= mArr[mPointer]){
                answer.add(nArr[nPointer++]);
            }
            else{
                answer.add(mArr[mPointer++]);
            }
        }
//
//        if(nPointer == n){
//            for(int i=mPointer; i<m; i++){
//                answer.add(mArr[i]);
//            }
//        }else{
//            for(int i=nPointer; i<n; i++){
//                answer.add(nArr[i]);
//            }
//        }

        while(nPointer != n) answer.add(nArr[nPointer++]);
        while(mPointer != m) answer.add(mArr[mPointer++]);

        System.out.println(answer);


    }
    public static void main(String[] args){

        Ex1 T = new Ex1();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nArr = new int[n];
        for(int i=0; i<n; i++)
            nArr[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] mArr = new int[m];
        for(int i=0; i<m; i++)
            mArr[i] = sc.nextInt();

        T.solution(n, m, nArr, mArr);
    }
}
