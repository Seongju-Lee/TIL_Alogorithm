package section5;

import java.util.*;


class WaitPerson {

    int idx = 0;
    int prior = 0;

    @Override
    public String toString(){
        return "(" + this.idx + ", " + this.prior + ")";
    }
    WaitPerson(int idx, int prior){

        this.idx = idx;
        this.prior = prior;
    }

}

public class Ex8_2 {

    int solution(int n, int m, int[] nArr) {

        Queue<WaitPerson> q = new LinkedList<>();
        int cnt = 0;
        boolean isLast = true;

        for(int i=0; i<n; i++) {
            q.offer(new WaitPerson(i, nArr[i]));
        }

        while (!q.isEmpty()) {

            WaitPerson tmp = q.poll();



            for(WaitPerson w : q) {
                if(tmp.prior < w.prior){
                    q.offer(tmp);
                    isLast = false;
                    break;
                }
            }

            if(isLast){
                cnt++;
                System.out.println("cnt 추가");

                if(tmp.idx == m) break;
                else tmp = null;

            }

            System.out.println(q);

            isLast = true;

        }

        System.out.println(cnt);


        return 0;

    }


    public static void main(String[] args){

        Ex8_2 T = new Ex8_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nArr = new int[n];

        for(int i=0; i<n; i++)
            nArr[i] = sc.nextInt();

        System.out.print(T.solution(n, m, nArr));

    }
}
