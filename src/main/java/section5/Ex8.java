package section5;

import section2.Ex6_2;

import java.util.*;
import java.util.stream.Collectors;

public class Ex8 {


    int solution(int n, int m, int[] nArr) {

        List<Integer> list = Arrays.stream(nArr).boxed().collect(Collectors.toList());
        int tmp = list.get(m);
        list.set(m, 0);
        Queue<Integer> q = new LinkedList<>(list);
        list.set(m, tmp);
        int cnt = 0;
        boolean isMax = true;

        // nArr[m]의 값을 tmp에 넣어놓는다.
        // nArr[m] 값을 0으로 표시해놓음

        /*
         반복을 돌면서 q.peek()이 리스트 내에서 가장 큰 수 인지 확인
         아니라면 -> q.poll()하여 q.offer()을 하여 맨 뒤로 보낸다.
         맞다면 -> q.poll()하고, cnt++한다.

         q.peek()이 0 이고, 리스트 내 tmp보다 큰 수가 있는 지 확인.
         */

        while (q.contains(0)) {
//            System.out.println(q);
            System.out.println("list: " + list);
            System.out.println("Queue: " + list);

            for (int i = 0; i < list.size(); i++) {

                if (q.peek() == 0) {
                    if (tmp < list.get(i)) {
                        q.offer(q.poll());
                        break;
                    }

                } else if (q.peek() < list.get(i)) {

                    q.offer(q.poll());
                    break;
                }

                if (i == list.size() - 1) {
                    int p = q.poll();
                    list.remove(new Integer(p));
                    cnt += 1;

                }
            }


        }

        System.out.println(cnt);



        return 0;

    }


    public static void main(String[] args){

        Ex8 T = new Ex8();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nArr = new int[n];

        for(int i=0; i<n; i++)
            nArr[i] = sc.nextInt();

        System.out.print(T.solution(n, m, nArr));

    }
}
