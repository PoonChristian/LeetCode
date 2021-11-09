// LeetCode 819: Most Common Word
// https://leetcode.com/problems/most-common-word/

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Put all the banned words in a HashSet for O(1) access
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        // Use a HashMap ather the wordFrequencies for each word in the paragraph
        Map<String, Integer> wordFrequencies = new HashMap<>();

        // Do some preprocessing on the paragraph to get all the paragraph words
        // 1. Replace all special characters with a space
        // 2. Convert all words to lowercase
        // 3. Split the words by space
        String[] paragraphWords = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");

        // Initialize a mostCommon and mostFrequent variable to keep track of as we iterate through the words
        String mostCommon = "";
        int mostFrequent = 0;
        
        for (String word : paragraphWords) {
            // Increment the frequency of the current word by 1
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
            
            // If the banned set doesn't contain the word and its frequency is greater than mostFrequent, update mostFrequent and mostCommon
            if (!bannedSet.contains(word) && wordFrequencies.get(word) > mostFrequent) {
                mostFrequent = wordFrequencies.get(word);
                mostCommon = word;
            }
        }
        
        // Return mostCommon
        return mostCommon;
    }
}
