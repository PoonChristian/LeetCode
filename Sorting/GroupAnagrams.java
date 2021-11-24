// LeetCode 49: Group Anagrams
// https://leetcode.com/problems/group-anagrams/

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Put the anagrams in a map where key = sorted anagram string, value = list of anagrams with same characters as sorted string
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        // Iterate through all strings in the input array
        for (String str : strs) {
            // Sort the string by converting it to a char array, sorting, and then creating a new string from the sorted array
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);

            // If the anagram map doesn't have the sorted string, then add the key and create a new ArrayList associated with it
            anagramMap.putIfAbsent(sortedStr, new ArrayList<>());

            // Add the original anagram string into the ArrayList
            anagramMap.get(sortedStr).add(str);
        }
        
        // Initialize the result list
        List<List<String>> anagrams = new ArrayList<>();

        // Add all the ArrayLists from the HashMap
        anagrams.addAll(anagramMap.values());

        // Return the result
        return anagrams;
    }
}