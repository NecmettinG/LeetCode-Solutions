//The solution of the problem called "Two Sum".
import java.util.Scanner;
import java.util.Arrays;

public class Solution{

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

        arrayInput = arrayInput.replaceAll("\\[|\\]", "").trim();

        String[] parts = arrayInput.split(",");

        numberArray = Arrays.stream(parts).map(String::trim).mapToInt(Integer::parseInt).toArray();

        System.out.println("target =");

        target = input.nextInt();

        answer = twoSum(numberArray, target);

        System.out.println(Arrays.toString(answer));

    }

}
