package section4;

import java.util.*;

public class Ex1 {

    public void solution(String s){

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        String answer = "";

        for(Character c : s.toCharArray()){
            if(map.get(c) != null)
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        List<Object> keyList = new ArrayList<>(map.keySet());
        List<Object> valueList = new ArrayList<>(map.values());

        for(int i=0; i<valueList.size()-1; i++){
            if(max < (int) valueList.get(i)){
                max = (int) valueList.get(i);
                answer = String.valueOf(keyList.get(i));
            }
        }


//        System.out.println(max);
        System.out.print(answer);
    }

    public static void main(String[] args){

        Ex1 T = new Ex1();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.solution(sc.next());
    }
}
