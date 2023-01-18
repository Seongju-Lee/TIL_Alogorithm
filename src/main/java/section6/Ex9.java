package section6;

import java.util.Arrays;
import java.util.Scanner;

public class Ex9 {

    int solution(int n, int m, int[] inputArr){

        /*
        left 와 righ
         */
        int[] cloneArr = inputArr.clone();
        Arrays.sort(cloneArr);
        int min = cloneArr[cloneArr.length-1];
        int max = 0;
        for(int i : inputArr)
            max += i;

        int[] tmp = new int[max-min+1];

        int temp = min;
        for(int i=0; i<tmp.length; i++){
            tmp[i] = temp++;
        }

        int left = 0;
        int right = tmp.length - 1;
        int middle = (left+right)/2;


        System.out.println(Arrays.toString(inputArr));
        System.out.println(Arrays.toString(tmp));


        int answer = -1;
        while (left <= right) {

            System.out.println(tmp[left] + ", " + tmp[middle] + ", " + tmp[right]);
            middle = (left+right)/2;
            System.out.println(tmp[middle]);

            int sum = 0;
            int bundle = 1;

            for (int i=0; i<inputArr.length; i++){

                sum += inputArr[i];

                if (sum > tmp[middle]) {
                    bundle += 1;
//                    i--;
                    sum = inputArr[i];
                }

                if(bundle > m ){
                    left = middle + 1;
                    break;
                } else if (bundle <= m && (i == inputArr.length - 1) ){
                    right = middle - 1;
                    answer = tmp[middle];
                }
            }


        }

        return answer;
    }

    public static void main(String[] args){

        Ex9 T = new Ex9();
        Scanner sc = new Scanner(System.in);

        int[] inputArr = new int[sc.nextInt()];
        int m = sc.nextInt();

        for(int i=0; i<inputArr.length; i++){
            inputArr[i] = sc.nextInt();
        }

        System.out.print(T.solution(inputArr.length, m, inputArr));

    }
}
