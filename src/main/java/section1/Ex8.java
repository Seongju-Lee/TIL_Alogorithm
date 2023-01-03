package section1;

import java.util.Scanner;

public class Ex8 {


    public Boolean solution1(String inputStr){

        /*
        String은 immutable 하기때문에 메모리에 새로 생성 되는 것이지만,
        solution() 메소드 내부에서 처리해야 하기때문에
        */

        inputStr = inputStr.toUpperCase();
        System.out.println(inputStr);

        for(int i=0; i<(inputStr.length() / 2); i++){
            System.out.println(inputStr.charAt(i) + "  " + inputStr.charAt((inputStr.length() - 1) -i));

            if(!(Character.isAlphabetic(inputStr.charAt(i)) && (Character.isAlphabetic(inputStr.charAt((inputStr.length() - 1) -i)))))
                continue;
            else if(!(inputStr.charAt(i) == inputStr.charAt((inputStr.length() - 1) -i)))
                return false;

        }

        return true;
    }

    public boolean solution2(String inputStr){

        inputStr = inputStr.toUpperCase().replaceAll("[^A-Z]", "");
        String reverseStr = new StringBuilder(inputStr).reverse().toString();

        return reverseStr.equals(inputStr) ? true : false;

    }
    public static void main(String[] args){

        Ex8 T = new Ex8();
        Scanner sc = new Scanner(System.in);

        System.out.print(T.solution2(sc.nextLine())? "YES" : "NO");
    }
}