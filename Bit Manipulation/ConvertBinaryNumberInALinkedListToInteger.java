// LeetCode 1290: Convert Binary Number in a Linked List to Integer
// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        // Initialize the decimal result to 0
        int decimal = 0;
        
        // Iterate through the linked list until we reach the end
        while (head != null) {
            /*
              Perform a bitwise left shift and then OR the new least significant 0 with the value at the head (1 or 0)
              Example: (1 -> 0 -> 1 -> null)
                1. decimal =  0 << 1  =   0 | 1 = 1
                2. decimal =  1 << 0  =  10 | 0 = 10
                3. decimal = 10 << 1  = 100 | 1 = 101
                4. 101 in binary is equal to 5 in decimal
            */
            decimal = decimal << 1 | head.val;
            head = head.next;
        }
        
         // By the end of the loop, all the values from the linked list will have been transferred to an int
        return decimal;
    }
}
