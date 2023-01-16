package section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Ex6 {


    int solution(int n, int k) {


        // n: 총 인원
        /*
            k: 외칠 숫자

            큐에 1부터 n까지 차례로 입력
            1부터 차례로 나오면서 다시 뒤쪽으로 삽입
            cnt == k번째로 나오는 숫자는 제거.
            cnt는 0으로 초기화 후, 다시 반복.

         */

        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();

        for(int i =1; i<=n; i++){
            q.offer(i);
        }

        while (q.size() != 1){

            System.out.println(q);

            int val = q.poll();
            q.add(val);
            cnt++;

            if(cnt == k){
                q.poll();
                cnt = 1;
            }

        }

        System.out.println(q);

        return q.peek();

    }



    public static void main(String[] args){

        Ex6 T = new Ex6();
        Scanner sc = new Scanner(System.in);

        System.out.print(T.solution(sc.nextInt(), sc.nextInt()));

    }
}
