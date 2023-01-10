package section3;

import java.util.*;

public class Ex2 {

    public void solution(int n, int m, int[] nArr, int[] mArr){

        Set nSet = new HashSet();
        Set mSet = new HashSet();

//        Set s = new HashSet(Arrays.asList(nArr));


        for(int i : nArr){
            nSet.add(i);
        }
        for(int i : mArr){
            mSet.add(i);
        }


//        for(Object obj : mSet){
//            if(nSet.contains(obj))
//                answer.add(obj);
//        }

        nSet.retainAll(mSet);

        ArrayList answer = new ArrayList(nSet);
        Collections.sort(answer);
        for(Object o : answer){
            System.out.print(o.toString() + " ");
        }

    }
    public static void main(String[] args){

        Ex2 T = new Ex2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nArr = new int[n];
        for(int i=0; i<n; i++)
            nArr[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] mArr = new int[m];
        for(int i=0; i<m; i++)
            mArr[i] = sc.nextInt();

        T.solution(n, m, nArr, mArr);
    }
}
