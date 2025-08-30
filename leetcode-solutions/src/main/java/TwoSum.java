//The solution of the problem called "Two Sum".
import java.util.Scanner;
import java.util.Arrays; //Arrays needed for manipulating input string into array.

public class TwoSum {

    public static int[] twoSum(int[] nums, int target){

        int tempTarget;
        int index = 0;
        int[] indexArray = new int[2];

        if(nums.length>=2 && nums.length<=Math.pow(10, 4) && target >= Math.pow(-10, 9) && target <= Math.pow(10, 9)){

            for(int i = 0; i < nums.length-1; i++){
                if(nums[i] >= Math.pow(-10, 9) && nums[i] <= Math.pow(10, 9)){
                    for(int j = i+1; j < nums.length; j++){
                        if(nums[j] >= Math.pow(-10, 9) && nums[j] <= Math.pow(10, 9)){

                            tempTarget = nums[i] + nums[j];
                            if(tempTarget == target){

                                indexArray[index] = i;
                                index++;
                                indexArray[index] = j;

                            }
                        }
                    }
                }
            }
        }
        return indexArray;
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int[] numberArray;
        int target;
        String arrayInput;
        int[] answer;

        System.out.println("nums =");
        arrayInput = input.nextLine();

        arrayInput = arrayInput.replaceAll("\\[|\\]", "").trim(); //Removing [ and ] from string and removing whitespaces.

        String[] parts = arrayInput.split(",");//Splitting the string at each comma and putting the elements into string array.

        numberArray = Arrays.stream(parts).map(String::trim).mapToInt(Integer::parseInt).toArray();
        /*stream(parts): creates a stream from the string array called parts.
        * map(String::trim): applies trim() to each string element to remove whitespaces.
        * mapToInt(Integer::parseInt): converts each string to an integer.
        * toArray(): collect the results into an array. This numberArray is an integer array currently.*/

        System.out.println("target =");

        target = input.nextInt();

        answer = twoSum(numberArray, target);

        System.out.println(Arrays.toString(answer)); //Turns the array into string.

    }

}
