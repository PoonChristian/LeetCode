// LeetCode 884: Uncommon Words from Two Sentences
// https://leetcode.com/problems/uncommon-words-from-two-sentences/

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        for (String word : A.split(" ")) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (String word : B.split(" ")) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        List<String> uniqueWords = new LinkedList<String>();

        for (String word : wordMap.keySet()) {
            if (wordMap.get(word) == 1) {
                uniqueWords.add(word);
            }
        }

        return uniqueWords.toArray(new String[uniqueWords.size()]);
    }
}