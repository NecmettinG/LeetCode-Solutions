import java.util.Scanner;
import java.util.Arrays;
public class MedianOfTwoSortedArrays{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array1 = nums1;
        int[] array2 = nums2;

        if (nums1.length > nums2.length) {
            array1 = nums2;
            array2 = nums1;
        }

        int m = array1.length;
        int n = array2.length;
        int left = 0;
        int right = m;

        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            double maxLeft1 = (partition1 == 0) ? Double.NEGATIVE_INFINITY : array1[partition1 - 1];
            double maxLeft2 = (partition2 == 0) ? Double.NEGATIVE_INFINITY : array2[partition2 - 1];

            double minRight1 = (partition1 == m) ? Double.POSITIVE_INFINITY : array1[partition1];
            double minRight2 = (partition2 == n) ? Double.POSITIVE_INFINITY : array2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }

                else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            }

            else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            }

            else {
                left = partition1 + 1;
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