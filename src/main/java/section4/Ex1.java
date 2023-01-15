package section4;

import java.util.*;

public class Ex1 {

    /**
     HashMap 주요 메소드
     map.getOrDefault(key, default): key의 value get 또는 default 리턴.
     map.containsKey(key) : key의 존재여부 리턴
     map.size(): key의 종류 개수.
     map.remove(key) : 특정 key 삭제 후, 해당 key의 value값 리턴. (oldValue)
      */

    public void solution(String s){

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        String answer = "";

        for(Character c : s.toCharArray()){
//            if(map.get(c) != null)
//                map.put(c, map.get(c) + 1);
//            else
//                map.put(c, 1);

            /**
             * get()을 이용해서 카운트할 때 위처럼 if문 사용도 좋지만,
             * geOrDefault()라는 메소드를 이용해서 한번에 가능.
              */


            map.put(c, map.getOrDefault(c, 0)  + 1);
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
