package section1;

import java.util.Scanner;

public class Ex1 {

    public static int solution(String str, char c){

        int cnt= 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        // foreach 문에서 : 뒤에 오는 것은 String은 올 수 없음.
        // iteratable 가능한 형태만 와야 함. -> Array, ArrayList, List, ...

        // Sting.toCharArray(): 문자열을 문자 하나씩 잘라서 배열로 만들어 줌.
        for(char x : str.toCharArray()){
            if(x == c) cnt++;
        }


        return cnt;
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print(solution(sc.next(), sc.next().charAt(0)));

    }

}
