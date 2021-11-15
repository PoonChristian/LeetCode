// LeetCode 246: Strobogrammatic Number
// https://leetcode.com/problems/strobogrammatic-number/

/*
    A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

    Write a function to determine if a number is strobogrammatic. The number is represented as a string.

    For example, the numbers "69", "88", and "818" are all strobogrammatic.

    Algorithm: Keep a map of the stroboprogrammatic numbers (0, 1, 8, 6, 9) and use two pointers to iterate towards the middle of the number/
        If a number does not map to its stroboprogrammatic counterpart, then return false. Otherwise if we get to the middle, return true. 
*/
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        // Initialize the HashMap with the strobogrammatic numbers
        HashMap<Character, Character> strobogrammaticMap = new HashMap<>();
        strobogrammaticMap.put('0','0');
        strobogrammaticMap.put('1','1');
        strobogrammaticMap.put('8','8');
        strobogrammaticMap.put('6','9');
        strobogrammaticMap.put('9','6');

        // Initialize two pointers to traverse from the beginning/end to the middle of the number
        int i = 0; 
        int j = num.length() - 1;
        
        // Iterate while i <= j because we want to consider the case of a string with only 1 character
        while (i <= j) {
            // Get the character at the beginning and then the character at the end
            char start = num.charAt(i);
            char end = num.charAt(j);

            // If the character at start doesn't map to the character at end, then return false
            if (start != strobogrammaticMap.getOrDefault(end, ' ')){
                return false;
            }

            // Otherwise, continue traversing
            i++;
            j--;
        }

        // Return true if we reach the middle without encountering a non-strobogrammatic number
        return true;
    }
}
