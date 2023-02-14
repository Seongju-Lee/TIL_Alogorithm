package baekjooon.string;

import java.util.*;

class Ex15829 {

    void solution(int L, String s) {

        long sum=0;

        for(int i=0; i<L; i++) {

            long sq = 1;

            for(int j=0; j<i; j++) {
                sq *= 31;
                sq %= 123_456_789_1L; // overflow 방지.
            }


            long tmp = ((int) s.charAt(i))%97;  // 소문자 알파벳 번호는 97(a) ~ 122(z)
            tmp += 1;
            sum += (tmp*sq);
            sum %= 123_456_789_1L;
        }

        System.out.print(sum%123_456_789_1L);

    }


    public static void main(String[] args) {

        Ex15829 main = new Ex15829();
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        String s = sc.next();

        main.solution(L, s);

    }
}