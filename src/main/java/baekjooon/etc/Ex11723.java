package baekjooon.etc;
import java.util.*;
import java.io.*;

public class Ex11723 {


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int m = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                String instruct = st.nextToken();

                if(instruct.equals("all")){
//                    set.clear();
                    set.addAll(Arrays.asList(1,2,3,4,5,67,8,9,10,11,12,13,14,15,16,17,18,19,20));
//                        new HashSet<>(Arrays.asList(1,2,3,4,5,67,8,9,10,11,12,13,14,15,16,17,18,19,20))
                }
                else if(instruct.equals("empty")) set.clear();

                else {

                    int val = Integer.parseInt(st.nextToken());

                    if (instruct.equals("add")) set.add(val);
                    else if (instruct.equals("remove")) set.remove(val);
                    else if (instruct.equals("check")) {
                        if (set.contains(val)) {
                            sb.append(1).append('\n');
                        } else {
                            sb.append(0).append('\n');
                        }
                    } else if (instruct.equals("toggle")) {
                        if (set.contains(val)) {
                            set.remove(val);
                        } else {
                            set.add(val);
                        }
                    }
                }
            }


            System.out.print(sb);

        }


}
