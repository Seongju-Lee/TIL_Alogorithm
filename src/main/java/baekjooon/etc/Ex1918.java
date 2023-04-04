package baekjooon.etc;
import java.util.*;

public class Ex1918 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>(); // 연산기호를 담기 위한 스택

        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) { // 현재 가리키는 문자가 사칙연산 또는 괄호일 때, stack을 다루기 위함.



                case '*':
                case '/':
                    if(stack.isEmpty() || stack.peek() == '(') {
                        stack.push(s.charAt(i));
                    }
                    else if(stack.peek()=='+' || stack.peek()=='-') {
                        stack.push(s.charAt(i));
                    } else if(stack.peek() == '*' || stack.peek() == '/') {
                        sb.append(stack.pop());
                        stack.push(s.charAt(i));
                    }
                    break;
                case '+':
                case '-':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }

                    stack.push(s.charAt(i));

                    break;

                case '(':
                    stack.push('(');
                    break;

                case ')':
                    while (stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;

                default:
                    sb.append(s.charAt(i));

            }
        }


        while (!stack.isEmpty()) {
            char c = stack.pop();
            if(c == '(') continue;
            else
                sb.append(c);
        }


        System.out.println("sb = " + sb);

    }
}
