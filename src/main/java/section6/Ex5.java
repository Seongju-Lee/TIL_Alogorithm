package section6;

import java.net.Inet4Address;
import java.util.*;

public class Ex5 {

    char solution(int n, int[] inputArr){


        Set<Integer> set = new TreeSet<>();

        for(int i : inputArr) {
            set.add(i);
        }

        if(inputArr.length == set.size()) return 'U';
        else return 'D';
    }

    public static void main(String[] args){

        Ex5 T = new Ex5();
        Scanner sc = new Scanner(System.in);

        int[] inputArr = new int[sc.nextInt()];

        for(int i=0; i<inputArr.length; i++){
            inputArr[i] = sc.nextInt();
        }

        System.out.print(T.solution(inputArr.length, inputArr));

    }
}
