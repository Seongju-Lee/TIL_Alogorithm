package baekjooon.UnionFind;
import java.util.*;


public class Ex11724 {

    // union-find
        static int[] arr;

        static void union(int a, int b) {
            int findA = find(a);
            int findB = find(b);

            if(findA != findB)
                arr[findA] = findB;
        }

        static int find(int a) {

            if(a == arr[a]) return arr[a];
            else return arr[a] = find(arr[a]);
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int m = sc.nextInt();

            arr = new int[n+1];
            for(int i=0; i<=n; i++) {
                arr[i] = i;
            }

            for(int i=0; i<m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                union(u, v);
            }


//            int bit = 0;
//            for(int i=1; i<=n; i++) {
//                bit |= (1<<find(i));
//            }
//
//            String s = Integer.toBinaryString(bit);
//            int answer=0;
//            for (int i = 0; i < s.length(); i++) {
//
//                if(s.charAt(i) == '1') answer++;
//            }

            Set<Integer> set = new HashSet<>();
            for(int i=1; i<=n; i++) {
                set.add(find(i));
            }
            System.out.print(set.size());



        }
}
