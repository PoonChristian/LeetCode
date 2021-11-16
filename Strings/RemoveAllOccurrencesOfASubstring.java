// LeetCode 1910: Remove All Occurrences of a Substring
// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/

public class RemoveAllOccurrencesOfASubstring {
    // Time Complexity: O(n) where n is the number of characters in s
    //          Reason: indexOf() is an O(n) operation and substring() is also an O(n) operation, but they are not nested. Therefore even though this goes through the string multiple times under the hood, it is still linear.
    // Space Complexity: O(1) since we are not allocating any new variables that grow in size as the algorithm runs
    public String removeOccurrencesIndexOfApproach(String s, String part) {
        // Get the index of the part within s
        // This loop will break if part does not exist in s
        while (s.indexOf(part) != -1) {
            // If it does exist in s, just extract the index of the first character
            int index = s.indexOf(part);

            // Set s equal to a new string that includes all the characters except for the part
            s = s.substring(0, index) + s.substring(index + part.length());
        }
        
        // Once the above loop breaks, we will have effectively removed all of "part" within s, so just return s
        return s;
    }


    // Time Complexity: O(n) where n is the number of characters in s
    //          Reason: We traverse through the string, and we also use substring() and equals() operations, which linearly scan as well.
    // Space Complexity: O(n) where n is the number of characters in s
    //          Reason: We're allocating a new StringBuilder variable that can potentially be the size of s
    public String removeOccurrencesStringBuilderApproach(String s, String part) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            // Append the character at the current index
            sb.append(s.charAt(i));
            
            // Whenever the StringBuilder's length is greater than or equal to the part's length, we must check whether or not the part exists at the end of the StringBuilder
            if (sb.length() >= part.length()) {
                // If the character we just added makes the end of the StringBuilder equal to the part, then just chop the part off from the StringBuilder by setting a new length that excludes the part
                if (sb.substring(sb.length() - part.length()).equals(part)) {
                    sb.setLength(sb.length() - part.length());
                }
            }
        }
        
        // Return the String from the StringBuilder
        return sb.toString();
    }
}