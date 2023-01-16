package section5;

import java.util.Scanner;
import java.util.Stack;

public class Ex4 {


    int solution(String s) {

        Stack<String> stack = new Stack<>();
        int answer = 0;
        for (Character c : s.toCharArray()) {

            System.out.println(stack);
            if (Character.isDigit(c)) {
                stack.push(c.toString());
            } else {
                int rt = Integer.valueOf(stack.pop().toString());
                int lt = Integer.valueOf(stack.pop().toString());

                switch (c) {

                    case '+':
                        int sum = lt + rt;
                        stack.push(sum + "");

                        break;


                    case '-':
                        int sub = lt - rt;
                        stack.push(sub+"");

                        break;

                    case '*':
                        int multiply = lt * rt;
                        stack.push(multiply + "");

                        break;

                    case '/':

                        int div = lt / rt;
                        stack.push(div + "");

                        break;

                }


            }
        }
//        System.out.println(stack.peek());

        return Integer.valueOf(stack.peek());
    }



    public static void main(String[] args){

        Ex4 T = new Ex4();
        Scanner sc = new Scanner(System.in);



        System.out.print(T.solution(sc.next()));

    }
}
