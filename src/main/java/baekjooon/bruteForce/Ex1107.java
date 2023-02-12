package baekjooon.bruteForce;

import java.util.*;

class Ex1107 {

    void solution(int n, int m, char[] broken) {

        int[] remote = new int[999_999];
        int cnt = 0;
        int min = Math.abs(100-n);

        for(int i=0; i<999_999; i++) {


            String moveChannel = String.valueOf(i);
            boolean notBroken = true;

            if(i != 0 && remote[i] == n) break;

            for(int j=0; j<moveChannel.length(); j++) {

                if(Arrays.binarySearch(broken, moveChannel.charAt(j)) >= 0) {



                    notBroken = false;
                    break;
                }
            }


            if(!notBroken){
                remote[i] = Math.abs(100-n);


            } else {
                remote[i] =  Math.abs(n - i);
            }


            cnt = moveChannel.length() + remote[i];

            if(min > cnt) {
                System.out.println(i + ", " + remote[i]);
                min = cnt;
            }

        }


        System.out.println(min);
    }

    public static void main(String[] args) {

        Ex1107 main = new Ex1107();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] broken = new char[m];


        for(int i=0; i<m; i++) {
            broken[i] = sc.next().charAt(0);
        }

        Arrays.sort(broken);
        System.out.println(Arrays.toString(broken));
        main.solution(n, m, broken);


    }
}