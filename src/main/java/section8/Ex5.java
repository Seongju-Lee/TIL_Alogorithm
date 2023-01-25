package section8;

import java.util.*;


public class Ex5 {

    static int root, sum, cnt=1;
    static int answer = Integer.MAX_VALUE;
    void DFS(int root, int M, int cnt, Integer[] arr) {


//        System.out.println(root +", " + cnt);
        if((root > M) || cnt > answer) return;
        else if (root == M){
            answer = Math.min(cnt, answer);
        }
        else {

            for(int i=0; i<arr.length; i++) {

                if((root+arr[i]) > M) return;
                else {
//                    cnt++;
                    DFS((root+arr[i]), M, cnt+1,arr);
//                    cnt--;
                }
            }
        }


    }
    public static void main(String[] args) {

        Ex5 T = new Ex5();
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();

        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        int M = sc.nextInt();

        for(int i : arr) {
            if(i < M) {
                root = Math.max(root, i);
            }
        }

        Arrays.sort(arr, Collections.reverseOrder());
        T.DFS(root, M , cnt, arr);

        System.out.print(answer);
    }
}
