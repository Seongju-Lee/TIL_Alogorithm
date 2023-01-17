package section6;

import java.util.*;

public class Ex6 {

    // 정렬만해도 쉽게 풀릴 문제가 꽤 많이 있음.
    ArrayList<Integer> solution(int n, int[] inputArr){

        ArrayList<Integer> answer = new ArrayList<>();

        int[] tmp = inputArr.clone();
        Arrays.sort(tmp);

        for(int i=0; i<n; i++){
            if(tmp[i] != inputArr[i]) answer.add(i+1);
        }

        return answer;
    }

    public static void main(String[] args){

        Ex6 T = new Ex6();
        Scanner sc = new Scanner(System.in);

        int[] inputArr = new int[sc.nextInt()];

        for(int i=0; i<inputArr.length; i++){
            inputArr[i] = sc.nextInt();
        }

        for(int i : T.solution(inputArr.length, inputArr)){
            System.out.print(i + " ");
        }
    }
}
