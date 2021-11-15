// LeetCode 937: Reorder Data in Log Files
// https://leetcode.com/problems/reorder-data-in-log-files/

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        // Sort the array based on the rules we are given for the problem
        Arrays.sort(logs, (log1, log2) -> {
            // The lambda function will follow the logic below
            // log1 < log2 -> -1 (priority goes to log1)
            // log1 == log2 -> 0 (log1 and log2 are not touched, they maintain their relative order)
            // log1 > log2 -> 1 (priority goes to log2)
                
            // Extract the identifiers and the contents of both logs by getting the first space of the string, and then get the id and content by extracting the substrings around the first space
            int index1 = log1.indexOf(" ");
            String id1 = log1.substring(0, index1);
            String content1 = log1.substring(index1 + 1);
            
            int index2 = log2.indexOf(" ");
            String id2 = log2.substring(0, index2);
            String content2 = log2.substring(index2 + 1);
            
            // Determine if the logs are digit-logs by checking the first character of their contents
            boolean isDigit1 = Character.isDigit(content1.charAt(0));
            boolean isDigit2 = Character.isDigit(content2.charAt(0));
            
            // If both logs are letter-logs, then we want to compare the contents lexicographically
            if (!isDigit1 && !isDigit2) {
                // content1.compareTo(content2) will compare both strings lexicographically
                int value = content1.compareTo(content2);
                
                // If the value is 0, that means both contents are exactly the same
                // This means we want to compare the ids lexicographically
                if (value == 0) {
                    return id1.compareTo(id2);
                }
                
                // Otherwise if they aren't the same, then just return the value
                return value;
            }
            
            /* Three Cases
                1. log1 is a digit-log and log2 is a digit-log
                        This means we want to maintain the relative ordering and not touch them -> return 0
                2. log1 is a digit-log and log2 is a letter-log
                        This means we want to put log2 before log1 -> return 1
                3. log1 is a letter-log and log2 is a digit-log (since the above if-statement would've tripped if both were letter-logs)
                        This means that we want to put log1 before log2 -> return -1
            */
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1; 
        });

        // Return the logs after sorting is complete
        return logs;
    }
}
