package section5;
import java.util.*;

public class Ex1 {

    /**
     * Stack 클래스 사용.
     * push()
     * pop()
     * isEmpty()
     * peek(): 스택의 최상단 값을 get
     *
     * @param s
     * @return
     */
    String solution(String s){

        Stack<Character> stack = new Stack<>();

        for(Character x : s.toCharArray()){

            if(x == '('){
                stack.push(x);
            }else if(x == ')'){
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return "NO";

        return "YES";
    }

    public static void main(String[] args){

        Ex1 T = new Ex1();
        Scanner sc = new Scanner(System.in);

        System.out.print(T.solution(sc.next()));

    }
}
