// LeetCode 1209: Remove All Adjacent Duplicates in String II
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        int[] count = new int[s.length()];
        char[] stringArray = s.toCharArray();
        int slow = 0;

        for (int fast = 0; fast < stringArray.length; fast++, slow++) {
            stringArray[slow] = stringArray[fast];
            if (slow == 0 || stringArray[slow] != stringArray[slow - 1]) {
                count[slow] = 1;
            } else {
                int addedCount = count[slow - 1] + 1;
                if (addedCount == k) {
                    slow -= k;
                } else {
                    count[slow] = addedCount;
                }
            }
        }

        return new String(stringArray, 0, slow);
    }
}