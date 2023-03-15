package baekjooon.etc;

import java.util.Scanner;

public class Ex17626 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num=0;

        int answer=4;

        while (true) {

            int tmp = n;
            int cnt=0;
            int val = ((int) (Math.sqrt(tmp))) - (num);

            for (int i = 1; i <= 4; i++) {

                System.out.println("val = " + val);

                tmp -= (val*val);
                System.out.println("tmp = " + tmp);
                if(tmp == 0){
                    cnt = i;
                    break;
                }
                val = (int) Math.sqrt(tmp);
            }
            if(tmp == 0 && answer>cnt) {
                answer = cnt;
            }


            if(cnt == 1 || ( ((int) Math.sqrt(n)) == num))
                break;

            num+=1;

        }

        System.out.println(answer);
    }
}
