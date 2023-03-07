package baekjooon.etc;
import java.util.*;
import java.io.*;

public class Ex11723 {


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int m = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();


            int s=0;
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                String instruct = st.nextToken();

                if(instruct.equals("all")) {
                    s = (1<<21)-1;
                } else if(instruct.equals("empty")) {
                    s = 0;
                }

                else {
                    int val = Integer.parseInt(st.nextToken());

                    if(instruct.equals("add")) {
                        s |= (1<<val);
                    } else if(instruct.equals("toggle")) {
                        s ^= (1<<val);
                    } else if(instruct.equals("remove")) {
//                        s = ~(s & (1<<val)); tilt는 내부적으로 32bit로 변환하여 리턴하기 때문에 마지막에 연산하면 안됨.
                        s &= ~((1<<val));
                    } else if(instruct.equals("check")) {
                        sb.append( (s & (1<<val) ) != 0 ? 1 : 0).append('\n');
                    }
                }
                System.out.println(Integer.toBinaryString(s));

            }

//            char[] c = {'a', 'b', 'c', 'd', 'e'};
//            int n=5;
//
//            for(int i=1; i<(1<<n); i++) {
//                System.out.print(i+"번째: ");
//
//                for(int j=0; j<n; j++) {
//                    if((i & (1<<j)) != 0){
//                        System.out.print(c[j] + " ");
//                    }
//                }
//                System.out.println();
//            }

            System.out.print(sb);

        }


}
