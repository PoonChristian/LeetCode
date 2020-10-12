// LeetCode 127: Word Ladder
// https://leetcode.com/problems/word-ladder/

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        int length = 1;
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                char[] currentWordArray = queue.remove().toCharArray();

                for (int j = 0; j < currentWordArray.length; j++) {
                    char originalChar = currentWordArray[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        currentWordArray[j] = c;

                        if (currentWordArray[j] == originalChar) {
                            continue;
                        }

                        String newWord = String.valueOf(currentWordArray);

                        if (newWord.equals(endWord)) {
                            return length + 1;
                        } else if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }

                    currentWordArray[j] = originalChar;
                }
            }

            length++;
        }

        return 0;
    }
}