package section5;

import java.util.Scanner;
import java.util.Stack;

public class Ex5 {


    int solution(String s) {


        // (): 레이저
        // '('가 나오고 인접한걸 제외한 그 다음 쌍인 ')'가 나오면 그것이 쇠막대기

        // tmp에 바로 직전에것 확인.
        // stack에 '('만 쌓음. & tmp에 현재 값 저장.
        // ')'가 나오는 순간 스택에 마지막에 들어간 것은 레이저로 한 쌍이므로
        // 만약 ')' & tmp=='('라면 -> 스택에서 마지막 들어간거 pop 후,  cnt += 스택의 개수
        // 만약 ')' & tmp--')' 라면 -> 스택에서 하나 pop 후, cnt =+ 1

        char tmp = ' ';
        int cnt = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){


            if(c == '(') stack.push(c);
            else{
                stack.pop();
                if(tmp == '(') cnt += stack.size();
                else cnt+=1;

            }

            tmp = c;
        }


        return cnt;
    }



    public static void main(String[] args){

        Ex5 T = new Ex5();
        Scanner sc = new Scanner(System.in);

        System.out.print(T.solution(sc.next()));

    }
}
