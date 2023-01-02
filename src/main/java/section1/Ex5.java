package section1;
import java.util.*;

public class Ex5 {

    public char[] solution(String inputStr){

        ArrayList<Character> alphaList = new ArrayList<>();
        char[] charArray = inputStr.toCharArray();


        for(char c : charArray){
            if(Character.isAlphabetic(c)){
                alphaList.add(c);
            }
        }

        for(int i=0; i<charArray.length; i++){
            if(Character.isAlphabetic(charArray[i])){
                charArray[i] = alphaList.get(alphaList.size() - 1);
                alphaList.remove(alphaList.size() - 1);
            }
        }

        return charArray;
    }

    public static void main(String[] args){

        Ex5 T = new Ex5();
        Scanner sc = new Scanner(System.in);

        System.out.print(T.solution(sc.next()));
    }
}