package baekjooon.etc;

import java.util.*;

class Ex5430{

    static String solution(char[] method, int n, StringBuilder sb) {

        boolean reverse = false;
        int start = 0;
        int end = n;

        for(int i=0; i<method.length; i++) {

            char m = method[i];

            if(m == 'R') {
                reverse = !reverse;
            }

            if( m == 'D' && !reverse) { // 앞에 삭제
                start += 1;
            } else if( m == 'D' && reverse) {
                end -= 1;
            }

        }

        String[] answer = sb.toString().split(",");

        if(start > end) {
            return "error";
        }else if(reverse) {

            String[] tmp = new String[end-start];
            int idx=0;

            for(int i=((end-1)); i>= start; i--) {
                tmp[idx++] = answer[i];
            }

            answer = tmp;
        } else {
            answer = Arrays.copyOfRange(answer, (start), end);
        }

        return Arrays.toString(answer).replaceAll(" ", "");

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<n; i++) {

            char[] method = sc.next().toCharArray();
            int len = sc.nextInt();
            String s= sc.next();
            s = s.replaceAll("\\[", "").replaceAll("]", "");
            StringBuilder sb = new StringBuilder(s);
            answer.append(solution(method, len, sb)).append('\n');
        }


        System.out.print(answer);

    }
}