import java.util.Scanner;
import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


public class AddTwoNumbers  {

    static class ListNode{

        int val;
        ListNode next;

        ListNode(){}

        ListNode(int val){this.val = val;}

        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); //Creating Dummyhead node which is a starter node. real linked list will start at dummyHead.next.
        ListNode current = dummyHead; //current node is for creating new nodes and forwarding through nodes.
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0; //If l1 is not null, val1 will equal to l1.val, else it will equal to 0.
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10); //creating a new node with sum value and current.next will point that node.
            current = current.next; //We assigned our new node as current node.
            //If you want to create new nodes and assign values, use this approach. Sometimes it is forgettable.

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next; //dummyHead.next is the starter of our linked list.
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("l1 = ");
        String arrayInput1 = input.nextLine();
        arrayInput1 = arrayInput1.replaceAll("\\[|\\]", "").trim();
        String[] parts1 = arrayInput1.split(",");
        int[] array1 = Arrays.stream(parts1).map(String::trim).mapToInt(Integer::parseInt).toArray();

        System.out.println("l2 = ");
        String arrayInput2 = input.nextLine();
        arrayInput2 = arrayInput2.replaceAll("\\[|\\]", "").trim();
        String[] parts2 = arrayInput2.split(",");
        int[] array2 = Arrays.stream(parts2).map(String::trim).mapToInt(Integer::parseInt).toArray();

        // Build first linked list
        ListNode l1 = buildLinkedList(array1);

        // Build second linked list
        ListNode l2 = buildLinkedList(array2);

        // Get the result
        ListNode result = addTwoNumbers(l1, l2);

        // Print the result
        printLinkedList(result);
    }

    // Helper method to build linked list from array
    public static ListNode buildLinkedList(int[] array) {
        if (array.length == 0) return null;

        ListNode head = new ListNode(array[0]); //Creating first node and assigning the index 0 as val. Head will indicate the starter of the linked list.
        ListNode current = head;

        for (int i = 1; i < array.length; i++) { //In this loop, we are going to create new nodes and assign the values that are from array.
            current.next = new ListNode(array[i]);
            current = current.next;
        }

        return head;
    }

    // Helper method to print linked list
    public static void printLinkedList(ListNode head) { //You don't have to create an array for answer and turn into string. We can use this approach.
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(", ");
            }
            head = head.next;
        }
        System.out.print("]");
    }
}