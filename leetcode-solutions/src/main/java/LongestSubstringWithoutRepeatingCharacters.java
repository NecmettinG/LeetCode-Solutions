import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {

        int maxNumberCounter = 0;
        int maxNumber = 0;
        //int maxNumberTemp = 0;
        boolean elseCondition = false;
        for(int x = 0; x < s.length(); x++){

            List<String> includedLetters = new ArrayList<>();
            maxNumberCounter = 0;
            elseCondition = false;
            for(int y = x; y < s.length(); y++){

                if(!includedLetters.contains(String.valueOf(s.charAt(y)))){

                    includedLetters.add(String.valueOf(s.charAt(y)));
                    maxNumberCounter++;
                    //maxNumberTemp = maxNumberCounter;
                    //System.out.println("Entered if block "+ y +" maxNumberCounter: "+maxNumberCounter);
                    elseCondition = false;
                }

                else{

                    elseCondition = true;

                    if(maxNumberCounter > maxNumber){
                        maxNumber = maxNumberCounter;
                        //System.out.println("Entered elses inner if block "+ y+" maxNumber: "+maxNumber);
                    }
                    //System.out.println("Entered else block"+ y);
                    break;
                }

            }

            if(!elseCondition && maxNumberCounter > maxNumber){

                maxNumber = maxNumberCounter;
            }

        }

        return maxNumber;

    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("s =");

        String ourString = input.nextLine();

        ourString = ourString.replaceAll("\"", "");

        int answer = lengthOfLongestSubstring(ourString);

        System.out.println(answer);
    }
}