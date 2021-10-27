// LeetCode 763: Partition Labels
// https://leetcode.com/problems/partition-labels/

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        // Initialize the result list to store the partition lengths
        List<Integer> partitions = new ArrayList<Integer>();

        // Initialize a char array that maps each character to its last index
        // Note: This is O(1) space because no matter how big the problem is, the array will always be size 26
        int[] lastIndexes = new int[26];
        
        // Iterate through the string and populate the character indices of the array with their last occurrence in the string
        for (int i = 0; i < s.length(); i++) {
            lastIndexes[s.charAt(i) - 'a'] = i;
        }
        
        // Initialize a pointer to walk through the string again while using the char array to determine when to partition
        int i = 0;
        
        // Iterate while i is still within the bounds of the string
        while (i < s.length()) {
            // Grab the end index of the current character
            int end = lastIndexes[s.charAt(i) - 'a'];

            // Initialize j equal to i in order to walk through the string until the end
            // Note: We set j equal to i because we want to include the current character in our processing
            //       There is a chance that the current character only occurs once at index i, so include it to prevent partitioning too early
            int j = i;
            
            // Iterate while j has not reached the end yet
            while (j < end) {
                // Two possibilities
                // 1. The index of the character at j is greater than the index of our current end
                // 2. Our current end still occurs after the index of the character at j
                // Update the end based on the latest occurrence to ensure we partition the least
                end = Math.max(end, lastIndexes[s.charAt(j++) - 'a']);
            }
            
            // Once the loop breaks, j will be pointing to the end
            // Add j - i + 1 to our partition (add 1 because strings have zero-based indexing)
            // Set i equal to the character after j (i.e. the character after the end of the partition we just made)
            partitions.add(j - i + 1);
            i = j + 1;
        }
        
        // Return the partitions array
        return partitions;
    }
}
