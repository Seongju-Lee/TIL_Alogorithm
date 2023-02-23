package Programmers;
import java.util.*;

public class Ex42839 {

        static int cnt;
        static Map<Integer, Boolean> map;
        void DFS(int depth, int n, int[] inputs, boolean[] visited, char[] value ) {

            if(depth == n) {

                StringBuilder sb = new StringBuilder();
                for(char c : value) {
                    sb.append(c);
                }

                int val=Integer.parseInt(sb.toString());
                if(val == 1 || val==0) return;
                if(map.getOrDefault(val, false)) return;

                boolean isPrime = true;
                for(int i=2; i<val; i++) {
                    if(val%i==0){
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime)
                    cnt+=1;
                map.put(val, true);
            } else {
                for(int i=0; i<inputs.length; i++) {
                    if(!visited[i]) {
                        visited[i] = true;
                        value[depth] = (char) (inputs[i] + '0');
                        DFS(depth+1, n, inputs, visited, value);
                        visited[i]= false;
                    }
                }
            }
        }

        public int solution(String numbers) {
            int answer = 0;
            int size = numbers.length();

            int[] inputs = new int[size];
            for(int i=0; i<size; i++) {
                inputs[i] = numbers.charAt(i) - '0';
            }
            boolean[] visited = new boolean[size];
            map = new HashMap<>();
            for(int i=1; i<=size; i++) { // 자릿 수
                DFS(0, i, inputs, visited, new char[i]);
            }
            return answer=cnt;
        }
    }

