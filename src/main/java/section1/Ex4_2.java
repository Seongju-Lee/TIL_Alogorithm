package section1;

import java.util.*;

public class Ex4_2 {

    public ArrayList<String> solution(ArrayList inputList){

        for(int i=0; i<inputList.size(); i++){
            inputList.set(i, new StringBuilder((String) inputList.get(i)).reverse().toString());
        }

        return inputList;
    }

    public static void main(String[] args){

        Ex4_2 T = new Ex4_2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<String> inputList = new ArrayList<String>();

        for(int i=0; i<n; i++){
            inputList.add(sc.next());
        }

        for(String x : T.solution(inputList)){
            System.out.println(x);

        }


    }
}
