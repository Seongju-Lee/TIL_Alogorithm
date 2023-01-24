package section8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {

    static int N;
    static int[] inputSet;
    static boolean[] visited;
    ArrayList<Integer> arrList = new ArrayList<>();
    static String answer = "NO";
    void solution(int idx) {


        if(idx == inputSet.length) {
            int tmp1 = 0;
            int tmp2 = 0;

            for(int i : inputSet) {
                if(visited[i-1]) tmp1 += (i);
                else tmp2 += i;
            }
//            for(int i=0; i< inputSet.length; i++) {
//                if(visited[i]) tmp1 += (i+1);
//                else if (!visited[i] && inputSet. (i+1)) tmp2 += (i+1);
//            }


//            System.out.println("tmp1: " + tmp1 + ", tmp2:" + tmp2);
            if(tmp1 == tmp2) answer = "YES";


        }
        else {
            visited[inputSet[idx]-1] = true;
            solution(idx + 1);
            visited[inputSet[idx]-1] = false;
            solution(idx + 1);
        }

    }
    public static void main(String[] args) {

        Ex1 T = new Ex1();
        Scanner sc = new Scanner(System.in);
        int max = 0;

        N = sc.nextInt();
        inputSet = new int[N];


        for(int i=0; i<N; i++) {
            inputSet[i] = sc.nextInt();
            if(max < inputSet[i]) max = inputSet[i];
        }
        visited = new boolean[max];

        T.solution(0);

        System.out.print(answer);
    }
}
