package section4;

import java.util.*;

public class Ex2 {


    /**
     * 아래 구현은 시간복잡도가 문자열의 길이일 뿐이다.
     *
     * 그런데, 문자열 길이^2만큼의 시간복잡도를 사용하고, map 객체를 하나만 구현함으로써 공간복잡도를 줄일 수도 있다.
     * 1. str1.toCharArray() 를 이용하여 하나의 map을 만든다.
     * 2. str2.toCharArray()의 반복을 통해서 map의 key에 대응하는 value-1을 반복한다.
     * 3. 중간에 0보다 작게 되면 false, 일치한 key가 없으면 false 또는 끝까지 갔는데 모든 값이 0이 아니면 false라는 경우의 수가 있을 수 있다.
     *    map.get() < 0            !map.containsKey(key)    map.get(key) != 0
     * @param str1
     * @param str2
     * @return
     */
    public boolean isAnagram(String str1, String str2){

        if(str1.length() != str2.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();


        for(int i=0; i<charArr1.length; i++){

            map1.put(charArr1[i], map1.getOrDefault(charArr1[i], 0)+1);
            map2.put(charArr2[i], map2.getOrDefault(charArr2[i], 0)+1);

        }


        return map1.equals(map2);

    }

    public static void main(String[] args){

        Ex2 T = new Ex2();
        Scanner sc = new Scanner(System.in);

        System.out.print(T.isAnagram(sc.next(), sc.next()) ? "YES" : "NO");
    }
}
