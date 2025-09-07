import java.util.Scanner;
import java.util.Arrays;
public class MedianOfTwoSortedArrays{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array1 = nums1;
        int[] array2 = nums2;

        if(array1.length > array2.length){

            array1 = nums2;
            array2 = nums1;
        }

        int total = (array1.length) + (array2.length);
        int half = total/2;

        int left = 0;
        int right = array1.length;

        double answer;

        while(left <= right){
            int medium1 = (left+right)/2;
            int medium2 = half - medium1;

            double array1Left = (medium1 > 0) ? array1[medium1-1] : Double.NEGATIVE_INFINITY;
            double array1Right = (medium1 < array1.length) ? array1[medium1] : Double.POSITIVE_INFINITY;
            double array2Left = (medium2 > 0) ? array2[medium2-1] : Double.NEGATIVE_INFINITY;
            double array2Right = (medium2 < array2.length) ? array2[medium2] : Double.POSITIVE_INFINITY;

            if(array1Left <= array2Right && array2Left <= array1Right){

                if(total % 2 == 1){

                    answer = Math.min(array1Right, array2Right);
                    return answer;
                }

                else{

                    answer = (Math.min(array1Right, array2Right) + Math.max(array1Left, array2Left)) / 2.0;
                    return answer;
                }
            }

            else if(array1Left > array2Right){

                right = medium1 - 1;
            }

            else{

                left = medium1 + 1;
            }
        }
        return 0;

    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("nums1 = ");

        String stringInput = input.nextLine();

        stringInput = stringInput.replaceAll("\\[|\\]", "").trim();

        String[] parts = stringInput.split(",");

        int[] nums1 = Arrays.stream(parts).map(String::trim).mapToInt(Integer::parseInt).toArray();

        System.out.println("nums2 = ");

        stringInput = input.nextLine();

        stringInput = stringInput.replaceAll("\\[|\\]", "").trim();

        parts = stringInput.split(",");

        int[] nums2 = Arrays.stream(parts).map(String::trim).mapToInt(Integer::parseInt).toArray();

        double answer = findMedianSortedArrays(nums1, nums2);

        System.out.println(answer);
    }
}